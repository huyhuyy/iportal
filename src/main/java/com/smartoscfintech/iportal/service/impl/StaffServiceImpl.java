package com.smartoscfintech.iportal.service.impl;
import com.smartoscfintech.iportal.common.util.DateUtils;
import com.smartoscfintech.iportal.controller.dto.StaffDto;
import com.smartoscfintech.iportal.controller.dto.UserDto;
import com.smartoscfintech.iportal.controller.dto.request.UserSearchRequest;
import com.smartoscfintech.iportal.controller.dto.response.PagingResponse;
import com.smartoscfintech.iportal.controller.dto.response.TransactionResponse;
import com.smartoscfintech.iportal.entity.StaffEntity;
import com.smartoscfintech.iportal.entity.TransactionEntity;
import com.smartoscfintech.iportal.repository.StaffRepository;
import com.smartoscfintech.iportal.repository.specification.StaffSpecification;
import com.smartoscfintech.iportal.service.StaffService;
import com.smartoscfintech.iportal.service.mapper.StaffMapper;
import com.smartoscfintech.iportal.service.mapper.TransactionMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffMapper staffMapper;
    private final StaffRepository staffRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public PagingResponse<UserDto> getListStaff(UserSearchRequest request) {
        Pageable pageable = request.getPaging().pageable();

        Specification<StaffEntity> specification = this.buildSpecification(request);
        Page<StaffEntity> entities = staffRepository.findAll(specification, pageable);
        List<UserDto> userDtos = entities.stream().
                map(staffMapper::mapToUserDto).collect(Collectors.toList());

        return new PagingResponse<>(userDtos,
                entities.getTotalElements(),
                entities.getTotalPages(),
                request.getPaging());
    }

    @Override
    public List<TransactionResponse> getTransactionByStaff(Long id) {
        Optional<StaffEntity> staff = staffRepository.findById(id);
        if(!staff.isPresent()) {
            throw new EntityNotFoundException();
        }
        List<TransactionEntity> transactionEntities = staff.get().getTransaction();
        List<TransactionResponse> transactionResponses = new ArrayList<>();
        transactionEntities.forEach(transactionEntity -> {
            TransactionResponse transactionResponse = transactionMapper.mapToTransactionResponse(transactionEntity);
            transactionResponses.add(transactionResponse);
        });
        return transactionResponses;
    }

    @Override
    public StaffDto getStaff(Long id) {
        Optional<StaffEntity> staff = staffRepository.findById(id);
        if (!staff.isPresent()) {
            throw new EntityNotFoundException();
        }
        return StaffMapper.INSTANCE.mapToDto(staff.get());
    }

    private Specification<StaffEntity> buildSpecification(UserSearchRequest request) {
        LocalDateTime fromDateCreated = DateUtils.convertLongToLocalDateTime(request.getCreatedDateFrom());
        LocalDateTime toDateCreated = DateUtils.convertLongToLocalDateTime(request.getCreatedDateTo());
        List<Long> withUserByIds = new ArrayList<>();
        return StaffSpecification.spec()
                .withFullName(request.getFullNameNormalize())
                .withActive (request.getStatus())
                .withRole(withUserByIds)
                .withCreatedDate(fromDateCreated, toDateCreated)
                .build();
    }
}

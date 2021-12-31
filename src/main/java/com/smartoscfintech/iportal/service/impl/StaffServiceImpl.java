package com.smartoscfintech.iportal.service.impl;
import com.smartoscfintech.iportal.common.util.DateUtils;
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
    public List<TransactionResponse> getTransactionOfStaff(Long id) {
        List<TransactionEntity> transactionEntities = staffRepository.findById(id).get().getTransaction();
        List<TransactionResponse> transactionResponses = transactionEntities.stream().
                map(transactionMapper::mapToTransactionResponse).collect(Collectors.toList());
        return transactionResponses;
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

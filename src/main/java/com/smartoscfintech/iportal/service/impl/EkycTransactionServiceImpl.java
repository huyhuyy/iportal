package com.smartoscfintech.iportal.service.impl;

import com.smartoscfintech.iportal.controller.dto.EkycTransactionDto;
import com.smartoscfintech.iportal.entity.EkycTransactionEntity;
import com.smartoscfintech.iportal.repository.EkycTransactionRepository;
import com.smartoscfintech.iportal.service.EkycTransactionService;
import com.smartoscfintech.iportal.service.mapper.EkycTransactionMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class EkycTransactionServiceImpl implements EkycTransactionService {
    private final EkycTransactionRepository ekycTransactionRepository;
    private final EkycTransactionMapper ekycTransactionMapper;

    @Override
    public EkycTransactionDto getEkycTransaction(Long id) {
        Optional<EkycTransactionEntity> ekycTransactionEntity = ekycTransactionRepository.findById(id);

        if(!ekycTransactionEntity.isPresent()) {
            throw new EntityNotFoundException();
        }
        EkycTransactionDto ekycTransactionDto = ekycTransactionMapper.mapToEkycTransactionDto(ekycTransactionEntity.get());
        return ekycTransactionDto;
    }
}

package com.smartoscfintech.iportal.service.mapper;

import com.smartoscfintech.iportal.controller.dto.TransactionDto;
import com.smartoscfintech.iportal.controller.dto.response.TransactionResponse;
import com.smartoscfintech.iportal.entity.RoleEntity;
import com.smartoscfintech.iportal.entity.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",
        imports = {RoleEntity.class, Collectors.class, Objects.class})

public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);
    @Named("mapTransactionEntity")
    @Mapping( target = "fullName", source = "entity.ekycTransaction.fullName")
    @Mapping( target = "IDNumber", source = "entity.ekycTransaction.documentNo")
    @Mapping( target = "doctype", source = "entity.ekycTransaction.docType")
    @Mapping( target = "ekycStatus", source = "entity.ekycTransaction.ekycStatus")
    TransactionResponse mapToTransactionResponse(TransactionEntity entity);

    TransactionDto mapToDto(TransactionEntity transactionEntity);
    TransactionEntity mapToEntity(TransactionDto transactionDto);
    List<TransactionDto> map(List<TransactionEntity> transactionEntities);
}

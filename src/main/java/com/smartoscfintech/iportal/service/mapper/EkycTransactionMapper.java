package com.smartoscfintech.iportal.service.mapper;


import com.smartoscfintech.iportal.controller.dto.EkycTransactionDto;
import com.smartoscfintech.iportal.entity.EkycTransactionEntity;
import com.smartoscfintech.iportal.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Objects;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",
        imports = {RoleEntity.class, Collectors.class, Objects.class})

public interface EkycTransactionMapper {
    @Mapping(target = "docType", source = "ekycTransactionEntity.docType")
    EkycTransactionDto mapToEkycTransactionDto(EkycTransactionEntity ekycTransactionEntity);
}

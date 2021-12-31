package com.smartoscfintech.iportal.service.mapper;

import com.smartoscfintech.iportal.controller.dto.EkycTransactionDto;
import com.smartoscfintech.iportal.entity.EkycTransactionEntity;
import com.smartoscfintech.iportal.entity.RoleEntity;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-30T21:56:27+0700",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class EkycTransactionMapperImpl implements EkycTransactionMapper {

    @Override
    public EkycTransactionDto mapToEkycTransactionDto(EkycTransactionEntity ekycTransactionEntity) {
        if ( ekycTransactionEntity == null ) {
            return null;
        }

        EkycTransactionDto ekycTransactionDto = new EkycTransactionDto();

        if ( ekycTransactionEntity.getDocType() != null ) {
            ekycTransactionDto.setDocType( ekycTransactionEntity.getDocType().name() );
        }
        ekycTransactionDto.setDocumentNo( ekycTransactionEntity.getDocumentNo() );
        ekycTransactionDto.setFullName( ekycTransactionEntity.getFullName() );
        if ( ekycTransactionEntity.getGender() != null ) {
            ekycTransactionDto.setGender( ekycTransactionEntity.getGender().name() );
        }
        ekycTransactionDto.setDob( ekycTransactionEntity.getDob() );
        ekycTransactionDto.setIssuingPlace( ekycTransactionEntity.getIssuingPlace() );
        ekycTransactionDto.setIssuingDate( ekycTransactionEntity.getIssuingDate() );
        ekycTransactionDto.setExpiryDate( ekycTransactionEntity.getExpiryDate() );
        ekycTransactionDto.setPermanentAddress( ekycTransactionEntity.getPermanentAddress() );
        ekycTransactionDto.setCurrentAddress( ekycTransactionEntity.getCurrentAddress() );

        return ekycTransactionDto;
    }
}

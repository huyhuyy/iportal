package com.smartoscfintech.iportal.service.mapper;

import com.smartoscfintech.iportal.controller.dto.TransactionDto;
import com.smartoscfintech.iportal.controller.dto.response.TransactionResponse;
import com.smartoscfintech.iportal.entity.EkycTransactionEntity;
import com.smartoscfintech.iportal.entity.RoleEntity;
import com.smartoscfintech.iportal.entity.TransactionEntity;
import com.smartoscfintech.iportal.entity.enums.DocType;
import com.smartoscfintech.iportal.entity.enums.EkycStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-30T16:06:10+0700",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public TransactionResponse mapToTransactionResponse(TransactionEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TransactionResponse transactionResponse = new TransactionResponse();

        transactionResponse.setFullName( entityEkycTransactionFullName( entity ) );
        transactionResponse.setIDNumber( entityEkycTransactionDocumentNo( entity ) );
        DocType docType = entityEkycTransactionDocType( entity );
        if ( docType != null ) {
            transactionResponse.setDoctype( docType.name() );
        }
        EkycStatus ekycStatus = entityEkycTransactionEkycStatus( entity );
        if ( ekycStatus != null ) {
            transactionResponse.setEkycStatus( ekycStatus.name() );
        }

        return transactionResponse;
    }

    @Override
    public TransactionDto mapToDto(TransactionEntity transactionEntity) {
        if ( transactionEntity == null ) {
            return null;
        }

        TransactionDto transactionDto = new TransactionDto();

        transactionDto.setId( transactionEntity.getId() );

        return transactionDto;
    }

    @Override
    public TransactionEntity mapToEntity(TransactionDto transactionDto) {
        if ( transactionDto == null ) {
            return null;
        }

        TransactionEntity transactionEntity = new TransactionEntity();

        transactionEntity.setId( transactionDto.getId() );

        return transactionEntity;
    }

    @Override
    public List<TransactionDto> map(List<TransactionEntity> transactionEntities) {
        if ( transactionEntities == null ) {
            return null;
        }

        List<TransactionDto> list = new ArrayList<TransactionDto>( transactionEntities.size() );
        for ( TransactionEntity transactionEntity : transactionEntities ) {
            list.add( mapToDto( transactionEntity ) );
        }

        return list;
    }

    private String entityEkycTransactionFullName(TransactionEntity transactionEntity) {
        if ( transactionEntity == null ) {
            return null;
        }
        EkycTransactionEntity ekycTransaction = transactionEntity.getEkycTransaction();
        if ( ekycTransaction == null ) {
            return null;
        }
        String fullName = ekycTransaction.getFullName();
        if ( fullName == null ) {
            return null;
        }
        return fullName;
    }

    private String entityEkycTransactionDocumentNo(TransactionEntity transactionEntity) {
        if ( transactionEntity == null ) {
            return null;
        }
        EkycTransactionEntity ekycTransaction = transactionEntity.getEkycTransaction();
        if ( ekycTransaction == null ) {
            return null;
        }
        String documentNo = ekycTransaction.getDocumentNo();
        if ( documentNo == null ) {
            return null;
        }
        return documentNo;
    }

    private DocType entityEkycTransactionDocType(TransactionEntity transactionEntity) {
        if ( transactionEntity == null ) {
            return null;
        }
        EkycTransactionEntity ekycTransaction = transactionEntity.getEkycTransaction();
        if ( ekycTransaction == null ) {
            return null;
        }
        DocType docType = ekycTransaction.getDocType();
        if ( docType == null ) {
            return null;
        }
        return docType;
    }

    private EkycStatus entityEkycTransactionEkycStatus(TransactionEntity transactionEntity) {
        if ( transactionEntity == null ) {
            return null;
        }
        EkycTransactionEntity ekycTransaction = transactionEntity.getEkycTransaction();
        if ( ekycTransaction == null ) {
            return null;
        }
        EkycStatus ekycStatus = ekycTransaction.getEkycStatus();
        if ( ekycStatus == null ) {
            return null;
        }
        return ekycStatus;
    }
}

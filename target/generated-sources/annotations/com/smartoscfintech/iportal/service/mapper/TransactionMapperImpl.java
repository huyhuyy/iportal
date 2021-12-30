package com.smartoscfintech.iportal.service.mapper;

import com.smartoscfintech.iportal.controller.dto.response.TransactionResponse;
import com.smartoscfintech.iportal.entity.EkycTransactionEntity;
import com.smartoscfintech.iportal.entity.GroupEntity;
import com.smartoscfintech.iportal.entity.RoleEntity;
import com.smartoscfintech.iportal.entity.StaffEntity;
import com.smartoscfintech.iportal.entity.TransactionEntity;
import com.smartoscfintech.iportal.entity.enums.DocType;
import com.smartoscfintech.iportal.entity.enums.EkycStatus;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-30T17:30:06+0700",
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
        transactionResponse.setBranch( entityStaffPrimaryGroupName( entity ) );
        transactionResponse.setApprover( entityApproverFullName( entity ) );
        EkycStatus ekycStatus = entityEkycTransactionEkycStatus( entity );
        if ( ekycStatus != null ) {
            transactionResponse.setEkycStatus( ekycStatus.name() );
        }

        return transactionResponse;
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

    private String entityStaffPrimaryGroupName(TransactionEntity transactionEntity) {
        if ( transactionEntity == null ) {
            return null;
        }
        StaffEntity staff = transactionEntity.getStaff();
        if ( staff == null ) {
            return null;
        }
        GroupEntity primaryGroup = staff.getPrimaryGroup();
        if ( primaryGroup == null ) {
            return null;
        }
        String name = primaryGroup.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String entityApproverFullName(TransactionEntity transactionEntity) {
        if ( transactionEntity == null ) {
            return null;
        }
        StaffEntity approver = transactionEntity.getApprover();
        if ( approver == null ) {
            return null;
        }
        String fullName = approver.getFullName();
        if ( fullName == null ) {
            return null;
        }
        return fullName;
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

package com.smartoscfintech.iportal.repository;

import com.smartoscfintech.iportal.entity.EkycTransactionEntity;
import com.smartoscfintech.iportal.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EkycTransactionRepository extends JpaRepository<EkycTransactionEntity, Long>, JpaSpecificationExecutor<EkycTransactionEntity> {
}

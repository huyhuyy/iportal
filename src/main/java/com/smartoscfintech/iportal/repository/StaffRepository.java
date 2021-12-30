package com.smartoscfintech.iportal.repository;


import com.smartoscfintech.iportal.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, Long>, JpaSpecificationExecutor<StaffEntity> {
}

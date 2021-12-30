package com.smartoscfintech.iportal.controller.dto;

import com.smartoscfintech.iportal.entity.StaffEntity;
import com.smartoscfintech.iportal.service.mapper.StaffMapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionDto {
    Long id;
}

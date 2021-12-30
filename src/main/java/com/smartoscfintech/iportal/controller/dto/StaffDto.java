package com.smartoscfintech.iportal.controller.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StaffDto {
    Long id;
    String fullName;
    String fullNameNormalize;
    String email;
    String username;
    long pending;
    long complete;
    Long id_Transaction;
}

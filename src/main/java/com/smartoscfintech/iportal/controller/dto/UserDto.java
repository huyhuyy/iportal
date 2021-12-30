package com.smartoscfintech.iportal.controller.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    Long id;
    String fullName;
    String fullNameNormalize;
    List <String> roles;
    String email;
    String phone;
    LocalDateTime createdDate;
    boolean active;

}

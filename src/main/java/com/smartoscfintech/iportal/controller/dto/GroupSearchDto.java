package com.smartoscfintech.iportal.controller.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupSearchDto {
    Long id;
    String name;
    String code;
}

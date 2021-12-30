package com.smartoscfintech.iportal.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SubmittedType {
    AUTO ("Auto"),
    NOT_AUTO ("Not Auto");

    private String name;
}

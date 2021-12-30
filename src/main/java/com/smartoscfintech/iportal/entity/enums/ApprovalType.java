package com.smartoscfintech.iportal.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApprovalType {
    MANUAL ("Manual"),
    AUTO ("Auto");

    private String name;

}

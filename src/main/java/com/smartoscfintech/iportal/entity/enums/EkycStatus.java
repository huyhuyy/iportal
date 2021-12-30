package com.smartoscfintech.iportal.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EkycStatus {
    PROCESS_FAIL("Process Fail"),
    APPROVE("Approve"),
    REJECT("Reject");
    private String name;
}

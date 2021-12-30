package com.smartoscfintech.iportal.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PermissionGroupType {
    DASHBOARD("Dashboard"),
    USER("User"),
    MANUAL_TRANSACTION("Manual Transaction"),
    TRANSACTION_LIST("Transaction List");

    private String name;
}

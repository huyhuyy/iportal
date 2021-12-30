package com.smartoscfintech.iportal.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PermissionScreenType {
    DASHBOARD("Dashboard"),
    BUSINESS_UNIT("Business Unit"),
    USER_MANAGEMENT("User Management"),
    ROLE_MANAGEMENT("Role Management"),
    MY_TASKS("My Tasks"),
    OTHER_TASKS("Other Tasks"),
    TRANSACTION_LIST("Transaction List");

    private String name;
}

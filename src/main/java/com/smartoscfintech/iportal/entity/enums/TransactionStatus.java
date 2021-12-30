package com.smartoscfintech.iportal.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Getter
public enum TransactionStatus {
    NEW ("New"),
    PROCESS_FAIL ("Process Fail"),
    APPROVE ("Approve"),
    REJECT ("Reject"),
    MANUAL_REVIEW ("Manual Review"),
    SUBMITTED_SUCCESS ("Submitted Success"),
    SUBMITTED_FAIL ("Submitted Fail");

    private String name;

    public static final List<TransactionStatus> COMPLETED_STATUS =
            Collections.unmodifiableList(Arrays.asList(APPROVE, REJECT, SUBMITTED_SUCCESS, SUBMITTED_FAIL));
}

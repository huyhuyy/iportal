package com.smartoscfintech.iportal.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorCode {
    public static final int FILE_DOWNLOAD_FAIL = 1001;
    public static final int FILE_UPLOAD_FAIL = 1002;
    public static final int MINIO_CREATE_BUCKET_FAIL = 1003;

    public static final int RESET_PASSWORD_TOKEN_INVALID = 1004;
    public static final int RESET_PASSWORD_INVALID = 1005;
    public static final int EMAIL_SEND_FAIL = 1006;

    public static final int REVIEW_TRANSACTION_STATUS_INVALID = 1007;
    public static final int REVIEW_TRANSACTION_NOT_ASSIGN = 1008;

    public static final int ASSIGN_TRANSACTION_INVALID = 1009;
    public static final int ASSIGN_TRANSACTION_IN_REVIEW = 1013;

    public static final int DUPLICATE_EKYC_TRANSACTION = 1010;
    public static final int DUPLICATE_ON_BOARDING_TRANSACTION = 1011;
    public static final int ON_BOARDING_BRANCH_NOT_MATCH = 1012;
    public static final int DUPLICATE_USER_EMAIL = 1013;
    public static final int DUPLICATE_USER_CODE = 1016;

    public static final int EXIST_USER_ACTIVE_GROUP = 1017;
    public static final int EXIST_TRANSACTION_GROUP = 1018;
    public static final int EXIST_USER_IN_GROUP = 1019;
    public static final int EXIST_MANAGER_IN_GROUP = 1020;

    public static final int FIELD_CANNOT_BLANK = 1021;
    public static final int DUPLICATE_USER_NAME = 1022;
    public static final int EXIST_USER_ACTIVE_ROLE = 1023;
}

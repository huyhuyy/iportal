package com.smartoscfintech.iportal.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
    private String fullName;
    private String IDNumber;
    private String doctype;
    private String branch;
    private String ekycStatus;
    private String approver;
}

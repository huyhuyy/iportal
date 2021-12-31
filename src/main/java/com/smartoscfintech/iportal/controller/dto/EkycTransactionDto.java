package com.smartoscfintech.iportal.controller.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EkycTransactionDto {
    String docType;
    String documentNo;
    String fullName;
    String gender;
    LocalDate dob;
    String issuingPlace;
    LocalDate issuingDate;
    LocalDate expiryDate;
    String permanentAddress;
    String currentAddress;
}

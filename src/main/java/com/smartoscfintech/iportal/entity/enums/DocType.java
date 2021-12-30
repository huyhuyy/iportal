package com.smartoscfintech.iportal.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DocType {
    PASSPORT ("Passport") ,
    DRIVING_LICENSE ("Driving License"),
    ID_CARD ("ID Card"),
    NATIONAL_ID("National ID");

    private String name;
}

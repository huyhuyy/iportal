package com.smartoscfintech.iportal.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OnBoardingType {
    CURRENT_ACCOUNT ("Current Account"),
    LENDING_ACCOUNT ("Lending Account"),
    SAVING_ACCOUNT ("Saving Account");

    private String name;
}

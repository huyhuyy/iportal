package com.smartoscfintech.iportal.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleType {
    ADMIN(1, "Admin"),
    SUPER_VISOR(2, "Supervisor"),
    TELLER(3, "Teller");
    private long id;

    private String role;
}

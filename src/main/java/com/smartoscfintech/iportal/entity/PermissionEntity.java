package com.smartoscfintech.iportal.entity;

import com.smartoscfintech.iportal.entity.enums.PermissionActionType;
import com.smartoscfintech.iportal.entity.enums.PermissionGroupType;
import com.smartoscfintech.iportal.entity.enums.PermissionScreenType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "permissions")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionEntity extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    PermissionGroupType groupFunction;

    @Enumerated(EnumType.STRING)
    PermissionScreenType screen;

    @Enumerated(EnumType.STRING)
    PermissionActionType action;

    @OneToMany(mappedBy = "permission", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RolePermissionEntity> rolePermissions = new ArrayList<>();
}

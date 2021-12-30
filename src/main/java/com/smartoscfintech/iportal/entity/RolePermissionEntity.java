package com.smartoscfintech.iportal.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "role_permission")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RolePermissionEntity extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    boolean allow;

    @ManyToOne(fetch = FetchType.LAZY)
    RoleEntity role;

    @ManyToOne(fetch = FetchType.LAZY)
    PermissionEntity permission;
}

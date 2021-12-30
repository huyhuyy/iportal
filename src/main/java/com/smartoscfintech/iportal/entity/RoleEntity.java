package com.smartoscfintech.iportal.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleEntity extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    boolean active;

    @Column(length = 50)
    String name;

    @Column(length = 300)
    String description;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserEntity> users = new ArrayList<>();

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RolePermissionEntity> rolePermissions = new ArrayList<>();
}

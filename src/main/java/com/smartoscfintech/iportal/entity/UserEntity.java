package com.smartoscfintech.iportal.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    boolean active;
    String password;

    @Column(length = 100)
    String username;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> roles = new ArrayList<>();

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    StaffEntity staff;
}

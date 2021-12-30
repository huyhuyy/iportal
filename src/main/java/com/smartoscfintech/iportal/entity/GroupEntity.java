package com.smartoscfintech.iportal.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupEntity extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    boolean active;

    @Column(length = 150)
    String name;

    @Column(length = 30)
    String code;

    @Column(length = 250)
    String address;

    @Column(length = 11)
    String phone;

    @ManyToOne
    LevelEntity level;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "group_id"), inverseJoinColumns = @JoinColumn(name = "staff_id"))
    private List<StaffEntity> users = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "group_id"), inverseJoinColumns = @JoinColumn(name = "staff_id"))
    private List<StaffEntity> managers = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    GroupEntity parent;
}

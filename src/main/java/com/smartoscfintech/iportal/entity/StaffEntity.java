package com.smartoscfintech.iportal.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "staff")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StaffEntity extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    boolean active;

    @Column(length = 150)
    String fullName;

    @Column(length = 150)
    String fullNameNormalize;

    @Column(length = 50)
    String email;

    @Column(length = 11)
    String phone;

    @Column(length = 300)
    String note;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY )
    UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    StaffEntity supervisor;

    @ManyToOne(fetch = FetchType.LAZY)
    GroupEntity primaryGroup;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<GroupEntity> userGroups = new ArrayList<>();

    @ManyToMany(mappedBy = "managers", fetch = FetchType.LAZY)
    private List<GroupEntity> managerGroups = new ArrayList<>();

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY )
    DocumentEntity avatar;

    //tro toi bien staff trong TransactionEntity
    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY)
    private List<TransactionEntity> transaction = new ArrayList<>();
}

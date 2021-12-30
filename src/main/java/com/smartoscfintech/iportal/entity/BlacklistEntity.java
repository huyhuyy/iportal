package com.smartoscfintech.iportal.entity;

import com.smartoscfintech.iportal.entity.enums.DocType;
import com.smartoscfintech.iportal.entity.enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blacklist")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BlacklistEntity extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    boolean active;
    String faceMapId;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    DocType docType;

    @Column(length = 50)
    String documentNo;

    @Column(length = 150)
    String fullName;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    Gender gender;

    LocalDate dob;

    @Column(length = 100)
    String issuingPlace;

    LocalDate issuingDate;

    LocalDate expiryDate;

    @Column(length = 250)
    String permanentAddress;

    @Column(length = 250)
    String currentAddress;

    @OneToMany(mappedBy = "blacklist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DocumentEntity> images = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    TransactionEntity transaction;
}

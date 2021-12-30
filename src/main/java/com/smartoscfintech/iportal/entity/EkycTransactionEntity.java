package com.smartoscfintech.iportal.entity;

import com.smartoscfintech.iportal.entity.enums.VerificationStatus;
import com.smartoscfintech.iportal.entity.enums.DocType;
import com.smartoscfintech.iportal.entity.enums.EkycStatus;
import com.smartoscfintech.iportal.entity.enums.Gender;
import com.smartoscfintech.iportal.entity.enums.MatchingStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ekyc_transaction")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EkycTransactionEntity extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String refTxnId;
    String customerRefId;

    @Size(max = 50)
    String customizedRefID;

    @Size(max = 50)
    String userReference;

    @Enumerated(EnumType.STRING)
    EkycStatus ekycStatus;

    @Size(max = 250)
    String errorCode;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    MatchingStatus faceMatching;

    Boolean liveness;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    VerificationStatus verificationStatus;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    DocType docType;

    @Size(max = 50)
    String documentNo;

    @Size(max = 150)
    String fullName;

    @Size(max = 150)
    String fullNameNormalize;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    Gender gender;

    LocalDate dob;

    @Size(max = 3)
    String issuingCountry;

    @Size(max = 100)
    String issuingPlace;

    LocalDate issuingDate;
    LocalDate expiryDate;

    @Size(max = 250)
    String permanentAddress;

    @Size(max = 250)
    String currentAddress;

    @OneToMany(mappedBy = "ekycTransaction", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DocumentEntity> images = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    TransactionEntity transaction;

    String faceMapId;
}

package com.smartoscfintech.iportal.entity;

import com.smartoscfintech.iportal.entity.enums.OnBoardingType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "onboarding")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OnBoardingEntity extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String refTxnId;
    LocalDateTime submittedDate;

    @Enumerated(EnumType.STRING)
    OnBoardingType workflowType;

    @OneToMany(mappedBy = "onboarding", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FieldEntity> fields = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    GroupEntity group;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    TransactionEntity transaction;
}

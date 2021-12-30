package com.smartoscfintech.iportal.entity;

import com.smartoscfintech.iportal.entity.enums.ApprovalType;
import com.smartoscfintech.iportal.entity.enums.SubmittedType;
import com.smartoscfintech.iportal.entity.enums.TransactionStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionEntity extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String refTxnId;
    LocalDateTime submittedDate;
    LocalDateTime assignDate;
    LocalDateTime approvedDate;
    LocalDateTime blockDate;
    String note;
    boolean block = false;

    @Enumerated(EnumType.STRING)
    ApprovalType approvalType;

    @Enumerated(EnumType.STRING)
    TransactionStatus status;

    @Enumerated(EnumType.STRING)
    SubmittedType submittedType;

    @OneToOne(mappedBy = "transaction", fetch = FetchType.LAZY)
    private OnBoardingEntity onboarding;

    @OneToOne(mappedBy = "transaction", fetch = FetchType.LAZY)
    private EkycTransactionEntity ekycTransaction;

    @ManyToOne(fetch = FetchType.LAZY)
    StaffEntity staff;

    @ManyToOne(fetch = FetchType.LAZY)
    StaffEntity approver;

    @OneToOne(fetch = FetchType.LAZY)
    RejectReason rejectReason;
}

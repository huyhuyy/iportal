package com.smartoscfintech.iportal.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "reject_reason")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RejectReason extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Size(max = 5)
    String rejectReasonCode;

    @Size(max = 255)
    String rejectReasonDescription;
}

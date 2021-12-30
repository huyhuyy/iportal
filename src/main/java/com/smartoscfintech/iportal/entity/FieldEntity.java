package com.smartoscfintech.iportal.entity;

import com.smartoscfintech.iportal.entity.enums.FieldType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "field")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FieldEntity extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    boolean active = true;
    int orderNumber;
    String groupLabel;
    String subGroupLabel;
    String label;
    String name;

    @Enumerated(EnumType.STRING)
    FieldType type;

    @Column(columnDefinition = "TEXT")
    String value;

    @ManyToOne(fetch = FetchType.LAZY)
    OnBoardingEntity onboarding;
}

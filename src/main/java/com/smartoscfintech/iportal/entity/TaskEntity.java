package com.smartoscfintech.iportal.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskEntity extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime startDate;
    LocalDateTime endDate;
    LocalDateTime finishDate;

    @Column(length = 50)
    String title;

    @Column(length = 300)
    String description;

    @ManyToOne(fetch = FetchType.LAZY)
    StaffEntity owner;
}

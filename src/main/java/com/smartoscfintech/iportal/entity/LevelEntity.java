package com.smartoscfintech.iportal.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "level")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LevelEntity extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int number;
    String name;
}

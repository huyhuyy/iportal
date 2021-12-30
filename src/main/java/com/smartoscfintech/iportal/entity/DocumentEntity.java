package com.smartoscfintech.iportal.entity;

import com.smartoscfintech.iportal.entity.enums.DocumentGroup;
import com.smartoscfintech.iportal.entity.enums.DocumentType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

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
@Table(name = "document")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DocumentEntity extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String uuid;
    String path;
    String bucket;

    @Enumerated(EnumType.STRING)
    DocumentGroup documentGroup;

    @Enumerated(EnumType.STRING)
    DocumentType type;

    @ManyToOne(fetch = FetchType.LAZY)
    EkycTransactionEntity ekycTransaction;

    @ManyToOne(fetch = FetchType.LAZY)
    BlacklistEntity blacklist;
}

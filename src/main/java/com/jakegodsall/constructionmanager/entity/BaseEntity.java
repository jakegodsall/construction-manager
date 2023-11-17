package com.jakegodsall.constructionmanager.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Objects;

@MappedSuperclass
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @EqualsAndHashCode @ToString
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    @Column(insertable = false, updatable = false)
    private Date createdDate;
    @Column(insertable = false, updatable = false)
    @UpdateTimestamp
    private Date lastModifiedDate;
}

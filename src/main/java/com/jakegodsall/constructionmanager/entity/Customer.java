package com.jakegodsall.constructionmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder @EqualsAndHashCode(callSuper = false) @ToString
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String emailAddress;

    @OneToMany(mappedBy = "customer")
    private Set<Job> jobs;

    @Builder
    public Customer(Long id,
                    Date createdDate,
                    Date lastModifiedDate,
                    Long version,
                    String firstName,
                    String lastName,
                    String phoneNumber,
                    String emailAddress) {
        super(id, createdDate, lastModifiedDate, version);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
}

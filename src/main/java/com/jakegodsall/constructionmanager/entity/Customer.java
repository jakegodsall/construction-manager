package com.jakegodsall.constructionmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customer")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder @EqualsAndHashCode(callSuper = false) @ToString
public class Customer extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email_address")
    private String emailAddress;
    @OneToMany(mappedBy = "customer")
    private Set<Job> jobs;
}

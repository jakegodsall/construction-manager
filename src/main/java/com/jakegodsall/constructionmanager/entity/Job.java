package com.jakegodsall.constructionmanager.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Customer customer;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus;
    private BigDecimal price;
    @OneToOne(cascade = CascadeType.ALL)
    private Quotation quotation;
    @OneToOne(cascade = CascadeType.ALL)
    private Invoice invoice;

}

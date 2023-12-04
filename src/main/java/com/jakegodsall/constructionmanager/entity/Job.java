package com.jakegodsall.constructionmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "job")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder @EqualsAndHashCode(callSuper = false) @ToString
public class Job extends BaseEntity {

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

    @Builder
    public Job(
            Long id,
            Date createdDate,
            Date lastModifiedDate,
            Customer customer,
            Address address,
            JobStatus jobStatus,
            BigDecimal price,
            Quotation quotation,
            Invoice invoice
    ) {
        super(id, createdDate, lastModifiedDate);
        this.customer = customer;
        this.address = address;
        this.jobStatus = jobStatus;
        this.price = price;
        this.quotation = quotation;
        this.invoice = invoice;
    }
}

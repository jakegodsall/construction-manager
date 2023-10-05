package com.jakegodsall.constructionmanager.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Quotation getQuotation() {
        return quotation;
    }

    public void setQuotation(Quotation quotation) {
        this.quotation = quotation;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Job job = (Job) o;
        return Objects.equals(customer, job.customer) && Objects.equals(address, job.address) && jobStatus == job.jobStatus && Objects.equals(price, job.price) && Objects.equals(quotation, job.quotation) && Objects.equals(invoice, job.invoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customer, address, jobStatus, price, quotation, invoice);
    }


}

package com.jakegodsall.constructionmanager.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customer")
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

    public Customer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(emailAddress, customer.emailAddress) && Objects.equals(jobs, customer.jobs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, phoneNumber, emailAddress, jobs);
    }


    @Override
    public String toString() {
        return "Customer: " + firstName + " " + lastName;
    }
}

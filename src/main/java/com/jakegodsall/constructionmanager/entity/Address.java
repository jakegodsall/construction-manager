package com.jakegodsall.constructionmanager.entity;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Address {
    private String street;
    private String city;
    private String postcode;

    public Address() {
    }

    public Address(String street,
                   String city,
                   String postcode) {
        this.street = street;
        this.city = city;
        this.postcode = postcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postCode) {
        this.postcode = postCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(postcode, address.postcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, postcode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postcode + '\'' +
                '}';
    }
}

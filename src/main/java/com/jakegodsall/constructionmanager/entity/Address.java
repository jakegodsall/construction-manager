package com.jakegodsall.constructionmanager.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.Objects;

@Embeddable
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder @EqualsAndHashCode @ToString
public class Address {
    private String street;
    private String city;
    private String postcode;
}

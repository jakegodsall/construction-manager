package com.jakegodsall.constructionmanager.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder @EqualsAndHashCode(callSuper = false)
@ToString
public class CustomerDto extends BaseDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    @Builder
    public CustomerDto(
            Long id,
            Date createdDate,
            Date lastModifiedDate,
            String firstName,
            String lastName,
            String phoneNumber,
            String emailAddress
    ) {
        super(id, createdDate, lastModifiedDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
}

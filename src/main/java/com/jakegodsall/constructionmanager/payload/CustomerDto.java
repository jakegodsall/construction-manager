package com.jakegodsall.constructionmanager.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder @EqualsAndHashCode(callSuper = false)
@ToString
public class CustomerDto extends BaseDto {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("email_address")
    private String emailAddress;
}

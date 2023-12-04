package com.jakegodsall.constructionmanager.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder @EqualsAndHashCode(callSuper = false) @ToString
public class JobDto extends BaseDto {

    private Long customerId;

    private String street;

    private String city;

    private String postCode;

    private String jobStatus;

    private BigDecimal price;

    private Long quotationId;

    private Long invoiceId;

    @Builder
    public JobDto(
            Long id,
            Date createdDate,
            Date lastModifiedDate,
            Long customerId,
            String street,
            String city,
            String postCode,
            String jobStatus,
            BigDecimal price,
            Long quotationId,
            Long invoiceId
    ) {
        super(id, createdDate, lastModifiedDate);
        this.customerId = customerId;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.jobStatus = jobStatus;
        this.price = price;
        this.quotationId = quotationId;
        this.invoiceId = invoiceId;
    }
}

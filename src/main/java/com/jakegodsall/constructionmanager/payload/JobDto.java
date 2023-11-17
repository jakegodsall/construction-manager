package com.jakegodsall.constructionmanager.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder @EqualsAndHashCode(callSuper = false) @ToString
public class JobDto extends BaseDto {
    @JsonProperty("customer_id")
    private Long customerId;
    private String street;
    private String city;
    @JsonProperty("post_code")
    private String postCode;
    @JsonProperty("job_status")
    private String jobStatus;
    private BigDecimal price;
    @JsonProperty("quotation_id")
    private Long quotationId;
    @JsonProperty("invoice_id")
    private Long invoiceId;
}

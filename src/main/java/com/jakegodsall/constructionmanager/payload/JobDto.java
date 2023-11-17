package com.jakegodsall.constructionmanager.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

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

    public JobDto() {
    }

    public JobDto(Long customerId,
                  String street,
                  String city,
                  String postCode,
                  String jobStatus,
                  BigDecimal price,
                  Long quotationId,
                  Long invoiceId) {
        this.customerId = customerId;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.jobStatus = jobStatus;
        this.price = price;
        this.quotationId = quotationId;
        this.invoiceId = invoiceId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(Long quotationId) {
        this.quotationId = quotationId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobDto jobDto = (JobDto) o;
        return Objects.equals(customerId, jobDto.customerId) && Objects.equals(street, jobDto.street) && Objects.equals(city, jobDto.city) && Objects.equals(postCode, jobDto.postCode) && Objects.equals(jobStatus, jobDto.jobStatus) && Objects.equals(price, jobDto.price) && Objects.equals(quotationId, jobDto.quotationId) && Objects.equals(invoiceId, jobDto.invoiceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, street, city, postCode, jobStatus, price, quotationId, invoiceId);
    }
}

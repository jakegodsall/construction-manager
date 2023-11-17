package com.jakegodsall.constructionmanager.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class BaseDto {
    private Long id;
    @JsonProperty("created_date")
    private Date createdDate;
    @JsonProperty("last_modified_date")
    private Date lastModifiedDate;

    public BaseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}

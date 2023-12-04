package com.jakegodsall.constructionmanager.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @EqualsAndHashCode @ToString
public class BaseDto {

    private Long id;

    @JsonProperty("created_date")
    private Date createdDate;

    @JsonProperty("last_modified_date")
    private Date lastModifiedDate;
}

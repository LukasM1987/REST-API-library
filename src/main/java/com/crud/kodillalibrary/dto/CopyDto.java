package com.crud.kodillalibrary.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CopyDto {

    @JsonProperty("ID")
    private Long id;

    @JsonProperty("TITLE_ID")
    private Long titleId;

    @JsonProperty("STATUS")
    private String status;
}

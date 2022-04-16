package com.crud.kodillalibrary.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReaderDto {

    @JsonProperty("ID")
    private Long id;

    @JsonProperty("FIRST_NAME")
    private String firstName;

    @JsonProperty("LAST_NAME")
    private String lastName;

    @JsonProperty("ACCOUNT_CREATION_DATE")
    private LocalDate accountCreationDate;
}

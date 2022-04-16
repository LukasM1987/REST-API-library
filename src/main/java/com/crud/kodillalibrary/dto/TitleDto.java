package com.crud.kodillalibrary.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TitleDto {

    @JsonProperty("ID")
    private Long id;

    @JsonProperty("TITLE")
    private String title;

    @JsonProperty("AUTHOR")
    private String author;

    @JsonProperty("PUBLICATION_YEAR")
    private int publicationYear;
}

package com.crud.kodillalibrary.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BorrowDto {

    @JsonProperty("ID")
    private Long id;

    @JsonProperty("BORROW_DATE")
    private LocalDate borrowDate;

    @JsonProperty("RETURN_DATE")
    private LocalDate returnDate;

    @JsonProperty("COPY_ID")
    private Long copyId;

    @JsonProperty("READER_ID")
    private Long readerId;
}

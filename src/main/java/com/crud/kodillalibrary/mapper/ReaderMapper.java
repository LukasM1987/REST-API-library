package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Reader;
import com.crud.kodillalibrary.dto.ReaderDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getFirstName(),
                readerDto.getLastName(),
                readerDto.getAccountCreationDate()
        );
    }

    public ReaderDto mapToReaderDto (final Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getFirstName(),
                reader.getLastName(),
                reader.getAccountCreationDate()
        );
    }

    public List<ReaderDto> mapToReaderDtoList (final List<Reader> reader) {
        return reader.stream()
                .map(this::mapToReaderDto)
                .collect(Collectors.toList());
    }
}

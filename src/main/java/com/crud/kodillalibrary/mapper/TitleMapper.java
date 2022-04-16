package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.dto.TitleDto;
import org.springframework.stereotype.Service;

@Service
public class TitleMapper {

    public Title mapToTitle(final TitleDto titleDto) {
        return new Title(
                titleDto.getId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getPublicationYear()
        );
    }

    public TitleDto mapToTitleDto (final Title title) {
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getPublicationYear()
        );
    }
}

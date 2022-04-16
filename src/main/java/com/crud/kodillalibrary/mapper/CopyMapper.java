package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Copy;
import com.crud.kodillalibrary.dto.CopyDto;
import com.crud.kodillalibrary.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CopyMapper {

    @Autowired
    private TitleRepository titleRepository;

    public Copy mapToCopy(final CopyDto copyDto) {
        return new Copy(
                copyDto.getId(),
                titleRepository.findTitleById(copyDto.getId()),
                copyDto.getStatus()
        );
    }

    public CopyDto mapToCopyDto(final Copy copy) {
        return new CopyDto(
                copy.getId(),
                copy.getTitle().getId(),
                copy.getStatus()
        );
    }

    public List<CopyDto> mapToCopyDtoList(final List<Copy> copy){
        return copy.stream().map(this::mapToCopyDto).collect(Collectors.toList());
    }
}

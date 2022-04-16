package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.domain.Reader;
import com.crud.kodillalibrary.dto.ReaderDto;
import com.crud.kodillalibrary.mapper.ReaderMapper;
import com.crud.kodillalibrary.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/copy")
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderService readerService;
    private final ReaderMapper readerMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getReader")
    public ReaderDto getReader(@RequestParam final Long readerId) {
        Reader reader = readerService.getReader(readerId);
        return readerMapper.mapToReaderDto(reader);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAllReaders")
    public List<ReaderDto> getAllReaders() {
        List<Reader> readers = readerService.getAllReaders();
        return readerMapper.mapToReaderDtoList(readers);
    }

    @RequestMapping(method = RequestMethod.POST, value = "addReader", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addReader(@RequestBody final ReaderDto readerDto) {
        Reader reader = readerMapper.mapToReader(readerDto);
        readerService.addReader(reader);
    }
}
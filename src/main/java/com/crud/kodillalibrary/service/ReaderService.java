package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.domain.Reader;
import com.crud.kodillalibrary.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private ReaderRepository readerRepository;

    public Reader getReader(Long id) {
        return readerRepository.findReaderById(id);
    }

    public Reader addReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }
}

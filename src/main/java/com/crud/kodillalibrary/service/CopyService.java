package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.domain.Copy;
import com.crud.kodillalibrary.repository.CopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CopyService {

    private CopyRepository copyRepository;

    public Copy addCopy(Copy copy) {
        return copyRepository.save(copy);
    }

    public Copy getCopy(Long id) {
        return copyRepository.findCopyById(id);
    }

    public List<Copy> getAllCopies() {
        return copyRepository.findAll();
    }
}
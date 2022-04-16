package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TitleService {

    private TitleRepository titleRepository;

    public Title addTitle(Title title) {
        return titleRepository.save(title);
    }

    public Title getTitle(Long id) {
        return titleRepository.findTitleById(id);
    }

    public List<Title> getAllTitle(Long id) {
        return titleRepository.findAll();
    }
}

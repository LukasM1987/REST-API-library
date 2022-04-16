package com.crud.kodillalibrary.controller;


import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.dto.TitleDto;
import com.crud.kodillalibrary.mapper.TitleMapper;
import com.crud.kodillalibrary.service.TitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/title")
@RequiredArgsConstructor
public class TitleController {

    private final TitleService titleService;
    private final TitleMapper titleMapper;

    @RequestMapping(method = RequestMethod.POST, value = "addTitle", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTitle(@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        titleService.addTitle(title);
    }
}

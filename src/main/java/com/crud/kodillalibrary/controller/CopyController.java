package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.domain.Copy;
import com.crud.kodillalibrary.dto.CopyDto;
import com.crud.kodillalibrary.mapper.CopyMapper;
import com.crud.kodillalibrary.service.CopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/copy")
@RequiredArgsConstructor
public class CopyController {

    private final CopyService copyService;
    private final CopyMapper copyMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getAllCopies")
    public List<CopyDto> getAllCopies() {
        List<Copy> copies = copyService.getAllCopies();
        return copyMapper.mapToCopyDtoList(copies);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCopy")
    public CopyDto getCopy(@RequestParam final Long copyId) {
        return copyMapper.mapToCopyDto(copyService.getCopy(copyId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addCopy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCopy(@RequestBody final CopyDto copyDto) {
        Copy copy = copyMapper.mapToCopy(copyDto);
        copyService.addCopy(copy);
    }
}

package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.domain.Borrow;
import com.crud.kodillalibrary.dto.BorrowDto;
import com.crud.kodillalibrary.mapper.BorrowMapper;
import com.crud.kodillalibrary.service.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library/borrow")
@RequiredArgsConstructor
public class BorrowController {

    private final BorrowService borrowService;
    private final BorrowMapper borrowMapper;

    @RequestMapping(method = RequestMethod.POST, value = "borrowBook")
    public BorrowDto borrowBook(@RequestParam final Long readerId, @RequestParam final Long copyId) {
        Borrow borrow = borrowService.borrowBook(copyId, readerId);
        return borrowMapper.mapToBorrowingDto(borrow);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "returnBook")
    public BorrowDto returnBook(final Long copyId) {
        return borrowMapper.mapToBorrowingDto(borrowService.returnBook(copyId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addBorrow", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBorrow(@RequestBody BorrowDto borrowDto) {
        Borrow borrow = borrowMapper.mapToBorrow(borrowDto);
        borrowService.addBorrow(borrow);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateReturnDate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BorrowDto updateReturnDate(@RequestBody BorrowDto borrowDto) {
        Borrow borrow = borrowMapper.mapToBorrow(borrowDto);
        Borrow update = borrowService.addBorrow(borrow);
        return borrowMapper.mapToBorrowingDto(update);
    }
}

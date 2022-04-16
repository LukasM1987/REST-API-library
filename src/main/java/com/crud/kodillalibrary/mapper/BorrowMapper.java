package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Borrow;
import com.crud.kodillalibrary.dto.BorrowDto;
import com.crud.kodillalibrary.repository.CopyRepository;
import com.crud.kodillalibrary.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowMapper {

    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private CopyRepository copyRepository;

    public Borrow mapToBorrow(final BorrowDto borrowDto) {
        return new Borrow(
                borrowDto.getId(),
                borrowDto.getBorrowDate(),
                borrowDto.getReturnDate(),
                copyRepository.findCopyById(borrowDto.getCopyId()),
                readerRepository.findReaderById(borrowDto.getReaderId())
        );
    }

    public BorrowDto mapToBorrowingDto (final Borrow borrow) {
        return new BorrowDto(
                borrow.getId(),
                borrow.getBorrowDate(),
                borrow.getReturnDate(),
                borrow.getCopy().getId(),
                borrow.getReader().getId()
        );
    }
}

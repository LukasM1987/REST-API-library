package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.domain.Borrow;
import com.crud.kodillalibrary.domain.Copy;
import com.crud.kodillalibrary.domain.Reader;
import com.crud.kodillalibrary.repository.BorrowRepository;
import com.crud.kodillalibrary.repository.CopyRepository;
import com.crud.kodillalibrary.repository.ReaderRepository;
import com.crud.kodillalibrary.status.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BorrowService {

    private ReaderRepository readerRepository;
    private CopyRepository copyRepository;
    private BorrowRepository borrowRepository;

    public Borrow borrowBook(final Long copyId, final Long readerId) {
        Copy copy = copyRepository.findCopyById(copyId);
        copy.setStatus(Status.BORROWED.getStatus());
        Reader reader = readerRepository.findReaderById(readerId);
        Borrow borrow = new Borrow();
        borrow.setBorrowDate(LocalDate.now());
        borrow.setCopy(copy);
        borrow.setReader(reader);
        borrowRepository.save(borrow);
        return borrow;
    }

    public Borrow returnBook(Long copyId) {
        Copy copy = copyRepository.findCopyById(copyId);
        copy.setStatus(Status.AVAILABLE.getStatus());
        copyRepository.save(copy);
        Borrow borrow = borrowRepository.findByCopyId(copyId);
        borrow.setReturnDate(LocalDate.now());
        borrowRepository.save(borrow);
        return borrow;
    }

    public Optional<Borrow> getBorrow(Long id) {
        return borrowRepository.findById(id);
    }

    public Borrow addBorrow(Borrow borrow) {
        return borrowRepository.save(borrow);
    }
}

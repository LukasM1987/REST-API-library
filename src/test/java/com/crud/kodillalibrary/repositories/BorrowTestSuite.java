package com.crud.kodillalibrary.repositories;

import com.crud.kodillalibrary.domain.Borrow;
import com.crud.kodillalibrary.domain.Copy;
import com.crud.kodillalibrary.domain.Reader;
import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.repository.BorrowRepository;
import com.crud.kodillalibrary.repository.CopyRepository;
import com.crud.kodillalibrary.repository.TitleRepository;
import com.crud.kodillalibrary.status.Status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BorrowTestSuite {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private TitleRepository titleRepository;

    @Test
    public void saveBorrowTest() {
        //Given
        Title title1 = new Title("Ostatnie zyczenie", "Sapkowski Andrzej", 1993);
        Title title2 = new Title("Czas pogardy", "Sapkowski Andrzej", 1995);
        Copy copy1 = new Copy(title1, Status.AVAILABLE.getStatus());
        Copy copy2 = new Copy(title2, Status.AVAILABLE.getStatus());

        title1.getCopies().add(copy1);
        title2.getCopies().add(copy2);

        copy1.setTitle(title1);
        copy2.setTitle(title2);

        titleRepository.save(title1);
        titleRepository.save(title2);

        Reader reader1 = new Reader("Lukasz", "Marchel", LocalDate.now());
        Reader reader2 = new Reader("Ola", "Kierzkiewicz", LocalDate.now());

        Borrow borrow1 = new Borrow();
        borrow1.setBorrowDate(LocalDate.now());
        borrow1.setReturnDate(LocalDate.now().plusDays(14));
        //borrow1.setCopy(copy1);
        borrow1.setReader(reader1);

        Borrow borrow2 = new Borrow();
        borrow2.setBorrowDate(LocalDate.now());
        borrow2.setReturnDate(LocalDate.now().plusDays(14));
        //borrow2.setCopy(copy2);
        borrow2.setReader(reader1);

        Borrow borrow3 = new Borrow();
        borrow3.setBorrowDate(LocalDate.now());
        borrow3.setReturnDate(LocalDate.now().plusDays(14));
        //borrow3.setCopy(copy2);
        borrow3.setReader(reader2);

        reader1.getBorrows().add(borrow1);
        copy1.getBorrows().add(borrow1);

        reader1.getBorrows().add(borrow2);
        copy2.getBorrows().add(borrow2);

        reader2.getBorrows().add(borrow3);
        copy2.getBorrows().add(borrow3);

        //When
        borrowRepository.save(borrow1);
        borrowRepository.save(borrow2);
        borrowRepository.save(borrow3);

        //Then
        assertEquals(2, reader1.getBorrows().size());
        assertEquals(1, reader2.getBorrows().size());
    }
}

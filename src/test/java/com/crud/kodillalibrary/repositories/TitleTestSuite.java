package com.crud.kodillalibrary.repositories;

import com.crud.kodillalibrary.domain.Copy;
import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.repository.TitleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TitleTestSuite {

    @Autowired
    private TitleRepository titleRepository;

    @Test
    public void addTitleTest() {
        //Given
        Title title = new Title("Ostatnie zyczenie", "Sapkowski Andrzej", 1993);

        //When
        titleRepository.save(title);
        Long id = title.getId();
        Optional<Title> testTitle = titleRepository.findById(id);

        //Then
        assertTrue(testTitle.isPresent());
        assertNotNull(id);

        //Clean Up
        titleRepository.deleteById(id);

    }

    @Test
    public void addTitleWithCopiesTest() {
        //Given
        Title title = new Title("Ostatnie zyczenie", "Sapkowski Andrzej", 1993);
        Copy firstCopy = new Copy();
        Copy secondCopy = new Copy();
        Copy thirdCopy = new Copy();

        title.getCopies().add(firstCopy);
        title.getCopies().add(secondCopy);
        title.getCopies().add(thirdCopy);

        firstCopy.setTitle(title);
        secondCopy.setTitle(title);
        thirdCopy.setTitle(title);

        //When
        titleRepository.save(title);
        Long id = title.getId();

        //Then
        assertNotEquals(Optional.of(0), id);

        //Clean Up
        titleRepository.deleteById(id);
    }
}

package com.crud.kodillalibrary.repositories;

import com.crud.kodillalibrary.domain.Reader;
import com.crud.kodillalibrary.repository.ReaderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReaderTestSuite {

    @Autowired
    private ReaderRepository readerRepository;

    @Test
    public void addReaderTest() {
        //Given
        Reader reader = new Reader("Lukasz", "Marchel", LocalDate.now());

        //When
        readerRepository.save(reader);
        Long id = reader.getId();
        Optional<Reader> testReader = readerRepository.findById(id);

        //Then
        assertTrue(testReader.isPresent());
        assertNotNull(id);

        //Clean Up
        readerRepository.deleteById(id);
    }
}

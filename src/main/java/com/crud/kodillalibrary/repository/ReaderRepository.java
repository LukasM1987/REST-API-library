package com.crud.kodillalibrary.repository;


import com.crud.kodillalibrary.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ReaderRepository extends CrudRepository<Reader, Long> {

    List<Reader> findByLastName(String lastName);
    List<Reader> findAll();
    Reader findReaderById(Long id);
}

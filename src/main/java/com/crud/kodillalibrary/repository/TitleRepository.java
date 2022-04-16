package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface TitleRepository extends CrudRepository<Title, Long> {

    List<Title> findAll();
    Title findTitleById(Long id);
}

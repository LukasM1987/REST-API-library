package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {

    List<Copy> findAll();
    Copy findCopyById(Long id);
}

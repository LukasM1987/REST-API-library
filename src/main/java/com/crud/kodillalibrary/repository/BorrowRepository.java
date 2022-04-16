package com.crud.kodillalibrary.repository;


import com.crud.kodillalibrary.domain.Borrow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BorrowRepository extends CrudRepository<Borrow, Long> {
    Borrow findByCopyId(Long id);
}

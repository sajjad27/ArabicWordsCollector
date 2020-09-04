package com.word;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface WordRepository extends CrudRepository<Word, BigDecimal> {
    List<Word> findByRawWord(String lastName);
}

package com.repository.repositories;

import com.entity.Phrase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PhraseRepository extends CrudRepository<Phrase, BigDecimal> {

}

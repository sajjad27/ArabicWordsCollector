package com.repository.facade;

import com.entity.Word;
import com.repository.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordFacade {

    @Autowired
    private WordRepository wordRepository;

    public void save(Word word) {
        wordRepository.save(word);
    }
}
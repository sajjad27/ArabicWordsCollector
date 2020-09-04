package com.repository.facade;

import com.entity.Phrase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhraseFacade {

    @Autowired
    private PhraseRepository phraseRepository;

    public void saveAll(List<Phrase> phrases) {
        phraseRepository.saveAll(phrases);
    }
}
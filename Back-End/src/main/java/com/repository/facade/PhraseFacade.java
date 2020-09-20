package com.repository.facade;

import com.entity.Phrase;
import com.repository.repositories.PhraseRepository;
import com.service.language.Messages;
import com.service.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhraseFacade {

    @Autowired
    private PhraseRepository phraseRepository;

    public void saveAll(List<Phrase> phrases) {
        try {
            Log.logFine(Messages.START_SAVING_ALL_PHRASES);
            phraseRepository.saveAll(phrases);
        } catch (DataIntegrityViolationException e) {
            Log.logWarning(Messages.DUPLICATED_URL_MSG.replace("{?}", ""));
        } catch (Exception e) {
            Log.logWarning(e.getMessage());
        }
    }
}
package com.repository.facade;

import com.entity.Page;
import com.repository.repositories.PageRepository;
import com.service.language.Messages;
import com.service.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
public class PageFacade {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PageRepository pageRepository;

    public void save(Page page) {

        try {
            pageRepository.save(page);
        } catch (DataIntegrityViolationException e) {
            Log.logWarning(Messages.DUPLICATED_URL_MSG.replace("{?}", page.getUrl()));
        } catch (Exception e) {
            Log.logWarning(e.getMessage());
        }
    }

    public void deleteAll() {
        pageRepository.deleteAll();
    }


    public Page findFirstUnconsumedPage(){
        Log.logFine(Messages.Find_FIRST_UNCONSUMED_PAGE);
        return findNumberOfUnconsumedPages(1).get(0);
    }

    public List<Page> findNumberOfUnconsumedPages(int limit) {
        Log.logFine(Messages.Find_NUMBER_OF_UNCONSUMED_PAGES);
        return entityManager.createQuery("SELECT p FROM Page p where p.isPageConsumed = '0'",
                Page.class).setMaxResults(limit).getResultList();
    }
}
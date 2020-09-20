package com.repository.facade;

import com.entity.Page;
import com.repository.repositories.PageRepository;
import com.service.language.Messages;
import com.service.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
public class PageFacade {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PageRepository pageRepository;

    @Transactional
    public void save(Page page) {
        try {
            Log.logFine(Messages.START_SAVING_ALL_PAGES);
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

    public void markThisPageAsConsumed(Page page){
        page.setPageConsumed(true);
        pageRepository.save(page);
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

    @Transactional(noRollbackFor = {Exception.class, java.lang.IllegalStateException.class,
            org.springframework.dao.DataIntegrityViolationException.class, org.hibernate.exception.ConstraintViolationException.class,
            java.sql.SQLIntegrityConstraintViolationException.class})
    public void saveAll(List<Page> pages){
        try {
            Log.logFine(Messages.START_SAVING_ALL_PAGES);
            pageRepository.saveAll(pages);
        } catch (DataIntegrityViolationException e) {
            Log.logWarning(Messages.DUPLICATED_URL_MSG.replace("{?}", ""));
        } catch (Exception e) {
            Log.logWarning(e.getMessage());
        }
//        for(Page page : pages)
//        {
//            save(page);
//        }
    }
}
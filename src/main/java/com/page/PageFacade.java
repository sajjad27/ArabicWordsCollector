package com.page;

import com.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PageFacade {

    @Autowired
    private PageRepository pageRepository;
    @Autowired
    private PageRepositoryImpl pageRepositoryImpl;

    public void save(Page page) {

        try {
            pageRepository.save(page);
        } catch (DataIntegrityViolationException e) {
            Log.LogDuplicatedUrl(page.getUrl());
        } catch (Exception e)
        {
            Log.log(e.getMessage());
        }
    }

    public void deleteAll()
    {
        pageRepository.deleteAll();
    }

    public Page findFirstUnconsumedPage(){
        return pageRepositoryImpl.findFirstUnconsumedPage();
    }
}
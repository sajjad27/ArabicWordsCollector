package com.page;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PageRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public Page findFirstUnconsumedPage(){
        return findNumberOfUnconsumedPages(1).get(0);
    }

    public List<Page> findNumberOfUnconsumedPages(int limit) {
        return entityManager.createQuery("SELECT p FROM Page p where p.isPageConsumed = '0'",
                Page.class).setMaxResults(limit).getResultList();
    }

}

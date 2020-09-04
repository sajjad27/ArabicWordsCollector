package com.page;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends CrudRepository<Page, String> {

    @Query(value = "SELECT p FROM Page p where p.isPageConsumed = '0'")
    public Page findFirstPage();

}

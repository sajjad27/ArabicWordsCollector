package com.controller;

import com.entity.Page;
import com.entity.pojo.PagePhraseWrapper;
import com.repository.facade.PageFacade;
import com.repository.facade.PhraseFacade;
import com.service.crawler.BasicWebCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Controller
public class MainController {
    @Autowired
    PageFacade pageFacade;
    @Autowired
    PhraseFacade phraseFacade;
    private String url = "https://www.aldiwan.net/";

    PagePhraseWrapper pagePhraseWrappers = new PagePhraseWrapper();

    public MainController() {
    }

    public void CollectArabicWordsFromTheInternetAndSaveThenInTheDB() {

        BasicWebCrawler crawler = new BasicWebCrawler();
        Page page = pageFacade.findFirstUnconsumedPage();

        while(!page.isPageConsumed()) {
            pagePhraseWrappers = crawler.getAllPagesAndAllArabicPhrasesFromThisPage(page);

            // to update isConsumed


            pageFacade.saveAll(pagePhraseWrappers.getPages());
            phraseFacade.saveAll(pagePhraseWrappers.getPhrases());

            pageFacade.markThisPageAsConsumed(page);

            page = pageFacade.findFirstUnconsumedPage();
        }


//        for (Phrase phrase : pagePhraseWrappers.getPhrases()) {
//            System.out.println(phrase.getRawPhrase());
//        }
//        for (Page printPage : pagePhraseWrappers.getPages()) {
//            System.out.println(printPage.getUrl());
//        }

    }


    public void saveOnePage(int i) {
//        pageFacade.deleteAll();
        pageFacade.save(new Page(i + url, false));
        System.out.println("done");
    }
}


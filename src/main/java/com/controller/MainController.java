package com.controller;

import com.entity.Page;
import com.entity.Phrase;
import com.entity.pojo.PagePhraseWrapper;
import com.repository.facade.PageFacade;
import com.service.crawler.BasicWebCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Controller
public class MainController {
    @Autowired
    PageFacade pageFacade;
    private String url = "https://www.aldiwan.net/";

    PagePhraseWrapper pagePhraseWrappers = new PagePhraseWrapper();

    public MainController() {
    }

    public void CollectArabicWordsFromTheInternetAndSaveThenInTheDB() {

        BasicWebCrawler crawler = new BasicWebCrawler();
        Page page = pageFacade.findFirstUnconsumedPage();
        pagePhraseWrappers = crawler.getAllPagesAndAllArabicPhrasesFromThisPage(page);
        for (Phrase phrase : pagePhraseWrappers.getPhrases()) {
            System.out.println(phrase.getRawPhrase());
        }
        for (Page printPage : pagePhraseWrappers.getPages()) {
            System.out.println(printPage.getUrl());
        }
    }

    public void saveOnePage(int i) {
//        pageFacade.deleteAll();
        pageFacade.save(new Page(i + url, false));
        System.out.println("done");
    }
}


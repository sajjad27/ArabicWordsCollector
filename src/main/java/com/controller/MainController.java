package com.controller;

import com.crawler.BasicWebCrawler;
import com.page.Page;
import com.page.PageFacade;
import com.phrase.Phrase;
import com.phrase.PhraseFacade;
import com.word.WordFacade;
import com.word.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Component
@Controller
public class MainController {
    @Autowired
    PageFacade pageFacade;
    @Autowired
    WordFacade wordFacade;
    @Autowired
    com.phrase.PhraseFacade phraseFacade;
    @Autowired
    PhraseFacade phraseTestFacade;
    WordService wordService = new WordService();
    private String url = "https://www.aldiwan.net/";

    public MainController() {
    }

    public void CollectArabicWordsFromTheInternetAndSaveThenInTheDB() {

        BasicWebCrawler crawler = new BasicWebCrawler();
        Page page = pageFacade.findFirstUnconsumedPage();
        // TODO mark page as processed
        List<Phrase> phrases = crawler.getAllArabicPhrasesFromThisUrl(page);
//        phraseFacade.saveAll();
        for(Phrase phrase : phrases)
        {
            System.out.println(phrase);
        }
//        List<Word> cleanWords = wordService.getCleanWordsFromTheseSentences(sentences);
    }

    public void saveOnePage(int i) {
//        pageFacade.deleteAll();
        pageFacade.save(new Page(i + url, false));
        System.out.println("done");
    }
}


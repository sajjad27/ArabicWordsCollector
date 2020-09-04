package com.crawler;

import com.page.Page;
import com.page.PageFacade;
import com.phrase.Phrase;
import com.word.WordService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public class BasicWebCrawler {

    @Autowired
    PageFacade pageFacade;

    public BasicWebCrawler() {
    }


    public List<Phrase> getAllArabicPhrasesFromThisUrl(Page page) {
        Document document = null;
        WordService wordService = new WordService();
        try {
            if (page != null) {
                document = Jsoup.connect(page.getUrl()).get();
                List<Phrase> phrases = wordService.getListOfPhrasesFromElements(document, page);
                return phrases;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
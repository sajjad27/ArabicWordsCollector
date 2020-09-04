package com.service.crawler;

import com.entity.Page;
import com.entity.pojo.PagePhraseWrapper;
import com.repository.facade.PageFacade;
import com.service.entityService.WordService;
import com.service.language.Messages;
import com.service.logging.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasicWebCrawler {

    @Autowired
    PageFacade pageFacade;

    public BasicWebCrawler() {
    }


    public PagePhraseWrapper getAllPagesAndAllArabicPhrasesFromThisPage(Page page) {
        Log.logFine(Messages.GET_ALL_PAGES_AND_ALL_ARABIC_PHRASES_FROM_THIS_PAGE.replace("{?}",page.getUrl()));
        Document document;
        WordService wordService = new WordService();
        PagePhraseWrapper pagePhraseWrapper = new PagePhraseWrapper();
        try {
            if (page != null) {
                document = Jsoup.connect(page.getUrl()).get();
                pagePhraseWrapper.setPhrases(wordService.getListOfPhrasesFromElements(document, page));
                pagePhraseWrapper.setPages(getAllPagesFromThisPage(page));
                return pagePhraseWrapper;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Page> getAllPagesFromThisPage(Page page) {
        try {
            if (page != null) {
                List<Page> pages = new ArrayList<>();
                Document document = Jsoup.connect(page.getUrl()).get();
                Elements elements = document.select("a[href]");
                String url;
                for (Element element : elements) {
                    url = element.attr("abs:href");
                    pages.add(new Page(url, false));
                }
                return pages;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
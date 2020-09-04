package com.entity.pojo;

import com.entity.Page;
import com.entity.Phrase;

import java.util.List;

public class PagePhraseWrapper {

    private List<Page> pages;
    private List<Phrase> phrases;

    public PagePhraseWrapper() { }

    public PagePhraseWrapper(List<Page> pages, List<Phrase> phrases) {
        this.pages = pages;
        this.phrases = phrases;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public List<Phrase> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<Phrase> phrases) {
        this.phrases = phrases;
    }
}

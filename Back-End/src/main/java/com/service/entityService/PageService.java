package com.service.entityService;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PageService {
    public List<String> getListOfCleanWordsFromSentence(String sentence) {
        List<String> words = new ArrayList<>();
        words = Arrays.asList(sentence.split(" ").clone());
        return words;
    }

    public List<String> getListOfCleanWordsFromElements(Elements elements) {
        List<String> words = new ArrayList<>();
        for (Element element : elements) {
        String wordsBetweenTags = element.ownText();
            words.addAll(getListOfCleanWordsFromSentence(wordsBetweenTags));
        }
        return words;
    }


}

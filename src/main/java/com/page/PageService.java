package com.page;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    public void Save(String filePath, List<String> words) {
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                FileWriter fileWriter = new FileWriter(filePath);
                for(String word : words) {
                    fileWriter.append(word + " ");
                    System.out.println(word);

                }
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}

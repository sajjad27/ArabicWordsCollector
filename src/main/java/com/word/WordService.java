package com.word;

import com.page.Page;
import com.phrase.Phrase;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordService {
    // TODO in clean word, check for:
//    1- nulls
    // grap all arabic string even the once which are in "alt='الديوان'"
    // delete ــ like in الطـــــــروب

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
                for (String word : words) {
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

    public List<Word> getCleanWordsFromTheseSentences(List<String> words) {
        for (String word : words) {
//            words.removeIf();
        }
//        return words;
        return null;
    }

    public List<String> getListOfWordsFromElement(Elements elements) {
        List<String> words = new ArrayList<>();
        for (Element element : elements) {
            String wordsBetweenTags = element.ownText();

            words.addAll(getListOfCleanWordsFromSentence(wordsBetweenTags));
        }
        return words;
    }


    public List<String> getListOfCleanWordsFromSentence(String sentence) {
        List<String> words = new ArrayList<>();
        words = Arrays.asList(sentence.split(" ").clone());
        return words;
    }

    public List<Phrase> getListOfPhrasesFromElements(Document document, Page page)
    {
        List<Phrase> phrases = new ArrayList<>();
        Phrase phrase = new Phrase();
        String rawPhrase = "";
        for (Element element : document.body().select("*")) {
            rawPhrase = element.ownText();
            if (!rawPhrase.isEmpty())
            {
//                phrase.setRawPhrase(element.ownText());
//                phrase.setPage(page);
                phrases.add(new Phrase(page, rawPhrase));
            }
        }
        return phrases;
    }
}

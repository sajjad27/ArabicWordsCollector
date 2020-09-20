package com.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
//@Table(name = "word", catalog = "arabicwordscollector")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal wordId;

    @Column(name = "rawWord")
    private String rawWord;

    public Word(){}

    public Word(BigDecimal wordId, String word) {
        this.wordId = wordId;
        this.rawWord = word;
    }

    public BigDecimal getWordId() {
        return wordId;
    }

    public void setWordId(BigDecimal wordId) {
        this.wordId = wordId;
    }

    public String getRawWord() {
        return rawWord;
    }

    public void setRawWord(String rawWord) {
        this.rawWord = rawWord;
    }

    @Override
    public String toString() {
        return "Word{" +
                "wordId=" + wordId +
                ", rawWord='" + rawWord + '\'' +
                '}';
    }
}

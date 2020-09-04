package com.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Phrase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal phraseId;

    @ManyToOne()
    private Page page;

    private String rawPhrase;

    public Phrase() { }

    public Phrase(Page page, String rawPhrase) {
        this.rawPhrase = rawPhrase;
        this.phraseId = phraseId;
    }

    public BigDecimal getPhraseId() {
        return phraseId;
    }

    public void setPhraseId(BigDecimal phraseId) {
        this.phraseId = phraseId;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getRawPhrase() {
        return rawPhrase;
    }

    public void setRawPhrase(String rawPhrase) {
        this.rawPhrase = rawPhrase;
    }
}

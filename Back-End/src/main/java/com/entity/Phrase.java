package com.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Transactional
public class Phrase {

    @Id
    @GeneratedValue(generator = "phrase_sequence-generator")
    @GenericGenerator(
            name = "phrase_sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "phrase_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private long phraseId;

    @ManyToOne()
    private Page page;

    private String rawPhrase;

    public Phrase() {
    }

    public Phrase(Page page, String rawPhrase) {
        this.rawPhrase = rawPhrase;
        this.phraseId = phraseId;
    }



    public long getPhraseId() {
        return phraseId;
    }

    public void setPhraseId(long phraseId) {
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

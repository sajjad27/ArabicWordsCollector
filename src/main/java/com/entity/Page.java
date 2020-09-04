package com.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Page {

    @Id
    @GeneratedValue(generator = "page_sequence-generator")
    @GenericGenerator(
            name = "page_sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "page_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private long id;

    @Column(nullable = false, unique = true)
    private String url;

    private boolean isPageConsumed;

    public Page() {
    }

    public Page(String url, boolean isPageConsumed) {
        this.url = url;
        this.isPageConsumed = isPageConsumed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isPageConsumed() {
        return isPageConsumed;
    }

    public void setPageConsumed(boolean pageConsumed) {
        isPageConsumed = pageConsumed;
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", isPageConsumed=" + isPageConsumed +
                '}';
    }
}

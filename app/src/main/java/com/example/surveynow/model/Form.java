package com.example.surveynow.model;

import java.util.Date;
import java.util.List;

public class Form {
    private String id;
    private String name;
    private String description;
    private String author;
    private List<QuestionType> questions;
    private Date createdAt;

    public Form() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<QuestionType> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionType> questions) {
        this.questions = questions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

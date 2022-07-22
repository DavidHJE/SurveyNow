package com.example.surveynow.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Form {
    public static String FIREBASE_COLLECTION = "form";

    private String id;
    private String name;
    private String description;
    private String author;
    private ArrayList<QuestionType> questions = new ArrayList<QuestionType>();
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

    public ArrayList<QuestionType> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<QuestionType> questions) {
        this.questions = questions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

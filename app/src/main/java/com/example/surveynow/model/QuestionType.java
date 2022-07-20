package com.example.surveynow.model;

public abstract class QuestionType {
    protected String id;
    protected Integer nb_question;
    protected String question;
    protected Boolean isRequired;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNb_question() {
        return nb_question;
    }

    public void setNb_question(Integer nb_question) {
        this.nb_question = nb_question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean required) {
        isRequired = required;
    }
}

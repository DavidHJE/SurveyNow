package com.example.surveynow.model;

import java.util.List;

public class RadioQuestion extends QuestionType {
    private List<String> choices;

    public RadioQuestion() {
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }
}

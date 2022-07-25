package com.example.surveynow.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Form implements Parcelable {
    public static String FIREBASE_COLLECTION = "form";

    private String id;
    private String name;
    private String description;
    private String author;
    private ArrayList<QuestionType> questions = new ArrayList<QuestionType>();
    private Date createdAt;

    public Form() {}

    protected Form(Parcel in) {
        id = in.readString();
        name = in.readString();
        description = in.readString();
        author = in.readString();
    }

    public static final Creator<Form> CREATOR = new Creator<Form>() {
        @Override
        public Form createFromParcel(Parcel in) {
            return new Form(in);
        }

        @Override
        public Form[] newArray(int size) {
            return new Form[size];
        }
    };

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

    @Override
    public String toString() {
        return "Form{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", questions=" + questions +
                ", createdAt=" + createdAt.toString() +
                '}';
    }

    public Boolean isValid() {
        return this.isNameValid() && this.isDescriptionValid() && this.isAuthorValid() && this.isCreatedAtValid();
    }

    private Boolean isNameValid() {
        return this.name != null && !this.name.trim().isEmpty();
    }

    private Boolean isDescriptionValid() {
        return this.description != null && !this.description.trim().isEmpty()
                && this.description.length() < 350;
    }

    private Boolean isAuthorValid() {
        return this.author != null && !this.author.trim().isEmpty()
                && this.author.length() < 60;
    }

    private Boolean isCreatedAtValid() {
        return this.createdAt != null && System.currentTimeMillis() >= this.createdAt.getTime();
    }

    public HashMap<String, Object> generateHashMapFirebase() {
        HashMap<String, Object> form = new HashMap<>();
        form.put("name", this.getName());
        form.put("description", this.getDescription());
        form.put("author", this.getAuthor());
        form.put("createdAt", this.getCreatedAt());

        return form;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(author);
    }
}

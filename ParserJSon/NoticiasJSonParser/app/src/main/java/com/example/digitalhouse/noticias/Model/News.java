package com.example.digitalhouse.noticias.Model;

import android.util.EventLogTags;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by digitalhouse on 19/10/16.
 */
public class News {

    @SerializedName("pepa")
    private String title;

    @SerializedName("Date")
    private String date;

    private String description;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}



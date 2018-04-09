package com.example.digitalhouse.noticias.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by digitalhouse on 19/10/16.
 */
public class Container {

    @SerializedName("pepe")
    private List<News> newsList;

    public List<News> getNewsList() {
        return newsList;
    }
}

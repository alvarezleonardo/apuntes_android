package com.ejemplo.noticias.controller;

import android.content.Context;

import com.ejemplo.noticias.dao.NewsDAO;
import com.ejemplo.noticias.model.News;

/**
 * Created by digitalhouse on 6/06/16.
 */
public class NewsController {

    public News getNews(Context context){
        NewsDAO newsDAO = new NewsDAO();
        News result = newsDAO.getNews(context);
        return result;
    }

}

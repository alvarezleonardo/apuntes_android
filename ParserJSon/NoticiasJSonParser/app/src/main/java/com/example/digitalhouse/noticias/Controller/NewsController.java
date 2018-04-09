package com.example.digitalhouse.noticias.Controller;

import android.content.Context;

import com.example.digitalhouse.noticias.DAO.NewsDAO;
import com.example.digitalhouse.noticias.Model.News;

/**
 * Created by digitalhouse on 19/10/16.
 */
public class NewsController {


    public News obtenerNoticia(Context context){
        //PEDIRLE AL DAO UNA NOTICIA
        NewsDAO newsDAO = new NewsDAO();
        News news = newsDAO.obtenerNoticiaDesdeJSON(context);
        return news;
    }














}

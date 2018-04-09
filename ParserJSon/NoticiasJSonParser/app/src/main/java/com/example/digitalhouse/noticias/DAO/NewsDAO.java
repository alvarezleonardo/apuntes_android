package com.example.digitalhouse.noticias.DAO;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Xml;

import com.example.digitalhouse.noticias.Model.Container;
import com.example.digitalhouse.noticias.Model.News;
import com.google.gson.Gson;

import org.xmlpull.v1.XmlPullParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by digitalhouse on 19/10/16.
 */
public class NewsDAO {

    public News obtenerNoticiaDesdeJSON(Context context) {

        News newsLeida = null;

        try {

            //ABRIR EL ARCHIVO
            AssetManager manager = context.getAssets();
            InputStream input = manager.open("news.json");

            //PARSER DE JSON
            BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(input));
            Gson gson = new Gson();
            Container container = gson.fromJson(bufferedReader, Container.class);
            newsLeida = container.getNewsList().get(0);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return newsLeida;
    }

    public News obtenerNoticiaDesdeXML(Context context) {

        News newsLeida = null;

        try {

            //ABRIR EL ARCHIVO
            AssetManager manager = context.getAssets();
            InputStream input = manager.open("news.xml");

            // LEER EL ARCHIVO

            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(input, null);
            Integer status = parser.getEventType();

            while (status != XmlPullParser.END_DOCUMENT) {

                switch (status) {

                    case XmlPullParser.START_DOCUMENT:
                        break;

                    case XmlPullParser.START_TAG:

                        if(parser.getName().equals("news")){
                            newsLeida = new News();
                        }

                        if(parser.getName().equals("title")){
                            String titulo = parser.nextText();
                            newsLeida.setTitle(titulo);
                        }

                        if(parser.getName().equals("description")){
                            newsLeida.setDescription(parser.nextText());
                        }

                        if(parser.getName().equals("date")){
                            //newsLeida.setDate(parser.nextText());
                        }

                        break;

                    case XmlPullParser.END_TAG:
                        break;
                }

                status = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newsLeida;

    }
}
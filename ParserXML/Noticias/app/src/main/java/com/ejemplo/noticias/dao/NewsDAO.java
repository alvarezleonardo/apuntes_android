package com.ejemplo.noticias.dao;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.util.Xml;

import com.ejemplo.noticias.model.News;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;

/**
 * Created by digitalhouse on 6/06/16.
 */
public class NewsDAO {

    public News getNews(Context context){
        XmlPullParser parser = Xml.newPullParser();
        News result = null;
        try{
            AssetManager manager = context.getAssets();
            InputStream input = manager.open("news.xml");
            // Vas a leer este archivo (input)
            parser.setInput(input, null);
            Integer status = parser.getEventType();
            while (status != XmlPullParser.END_DOCUMENT){
                switch (status){
                    case XmlPullParser.START_DOCUMENT:
                        result = new News();
                        break;
                    case XmlPullParser.START_TAG:
                        if (parser.getName().equals("title")){
                            result.setTitle(parser.nextText());
                        }else if (parser.getName().equals("author")){
                            result.setAuthor(parser.nextText());
                        }else if (parser.getName().equals("date")){
                            result.setDate(parser.nextText());
                        }else if (parser.getName().equals("description")){
                            result.setDescription(parser.nextText());
                        }
                        break;
                }
                status = parser.next();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        Log.d("INFO", "termino");

        return result;
    }


}

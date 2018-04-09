package com.ejemplo.personas.dao;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.util.Xml;

import com.ejemplo.personas.model.Person;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by digitalhouse on 6/06/16.
 */
public class PersonDAO {

    public List<Person> getPerson(Context context){
        XmlPullParser parser = Xml.newPullParser();
        Person result = null;
        List<Person> listPersona = new ArrayList<>();
        try{
            AssetManager manager = context.getAssets();
            InputStream input = manager.open("person.xml");
            // Vas a leer este archivo (input)
            parser.setInput(input, null);
            Integer status = parser.getEventType();
            while (status != XmlPullParser.END_DOCUMENT){
                switch (status){
                    case XmlPullParser.START_DOCUMENT:
                        result = new Person();
                        break;
                    case XmlPullParser.START_TAG:
                        if (parser.getName().equals("person")) {
                            result = new Person();
                        }else if (parser.getName().equals("name")){
                            result.setName(parser.nextText());
                        }else if (parser.getName().equals("lastName")){
                            result.setLastName(parser.nextText());
                        }else if (parser.getName().equals("lastTweet")){
                            result.setLastTweet(parser.nextText());
                        }else if (parser.getName().equals("age")){
                            result.setAge(parser.nextText());
                            listPersona.add(result);

                        }

                        break;
                }

                //Log.d("INFO", result.toString());
                status = parser.next();
            }
        }catch (Exception e){
            e.printStackTrace();
        }



        return listPersona;
    }


}

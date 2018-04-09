package com.example.digitalhouse.noticias.DAO;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;

import com.example.digitalhouse.noticias.Model.Container;
import com.example.digitalhouse.noticias.Model.News;
import com.example.digitalhouse.noticias.utils.HTTPConnectionManager;
import com.example.digitalhouse.noticias.utils.ResultListener;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by digitalhouse on 19/10/16.
 */
public class NewsDAO {



    public void obtenerNoticiaDesdeJSON(Context unContext, ResultListener<News> listenerFromController) {

        //EJECUTA UNA TAREA ASINCRONA PARA LEER UN ARCHIVO
        ReadFromJSONFileAsync readFromJSONFile = new ReadFromJSONFileAsync(unContext, listenerFromController);
        readFromJSONFile.execute();

    }


    private class ReadFromJSONFileAsync extends AsyncTask<String, Void, News> {

        private Context context;
        private ResultListener<News> listenerFromController;

        public ReadFromJSONFileAsync(Context context, ResultListener<News> listenerFromController) {
            this.context = context;
            this.listenerFromController = listenerFromController;
        }

        @Override
        protected News doInBackground(String... strings) {

            //TRABAJO PESADO QUE SE HACE EN SEGUNDO PLANO
            News newsLeida = null;

            try {

                //HAGO UN REQUEST HTTP
                HTTPConnectionManager httpConnectionManager = new HTTPConnectionManager();
                InputStream input = httpConnectionManager.getRequestStream("https://api.myjson.com/bins/1nev4");

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

        @Override
        protected void onPostExecute(News newsLeida) {
            listenerFromController.finish(newsLeida);
        }
    }






















}
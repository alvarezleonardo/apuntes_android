package com.example.digitalhouse.parserbase.dao;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;

import com.example.digitalhouse.parserbase.model.Canales;
import com.example.digitalhouse.parserbase.model.Contenedor;
import com.example.digitalhouse.parserbase.util.ResultListener;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by leona on 26/10/2016.
 */

public class DaoCanales {

    public List<Canales> obtenerCanalesJSON(Context context, ResultListener<List<Canales>> listenerFromController) {
        //EJECUTA UNA TAREA ASINCRONA PARA LEER UN ARCHIVO
        ReadFromJSONFileAsync readFromJSONFile = new ReadFromJSONFileAsync(unContext, listenerFromController);
        readFromJSONFile.execute();

        private class ReadFromJSONFileAsync extends AsyncTask<String, Void, List<Canales>> {

        }

        List<Canales> canalesList = null;

        try {

            //ABRIR EL ARCHIVO
            AssetManager manager = context.getAssets();
            InputStream input = manager.open("canales.json");

            //PARSER DE JSON
            BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(input));
            Gson gson = new Gson();
            Contenedor container = gson.fromJson(bufferedReader, Contenedor.class);
            canalesList = container.getCanalesList();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return canalesList;
    }

}

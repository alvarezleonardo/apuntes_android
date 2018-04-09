package com.example.digitalhouse.mylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaro el ListView, y lo referencio al View del layout
        ListView lstListaPersonas;
        lstListaPersonas=(ListView)findViewById(R.id.ListView_Lista_Personas);

        //Declaro e instancio el Adapter, que se basa en mi clase
        //AdaptadorPersonas.  Al instanciarlo, le mando el contexto de la
        //Activity, y el ArrayList
        AdaptadorPersonas miAdaptadorDePersonas;
        miAdaptadorDePersonas = new AdaptadorPersonas(this, obtenerPersonas());

        //Le asigno el Adapter al ListView
        lstListaPersonas.setAdapter(miAdaptadorDePersonas);


    }


    public ArrayList<String> obtenerPersonas() {

        ArrayList<String> listaPersonas = new ArrayList<>();

        listaPersonas.add("Mauro");
        listaPersonas.add("Martin");
        listaPersonas.add("Jaime");
        listaPersonas.add("Bocha");
        listaPersonas.add("Tito");
        listaPersonas.add("Ariel");
        listaPersonas.add("Miguelito");
        listaPersonas.add("Nahuelito");
        listaPersonas.add("Nacho");

        return listaPersonas;

    }


}












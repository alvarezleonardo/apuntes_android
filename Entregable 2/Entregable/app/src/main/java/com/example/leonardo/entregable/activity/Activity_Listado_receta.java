package com.example.leonardo.entregable.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.leonardo.entregable.fragment.Fragment_receta;
import com.example.leonardo.entregable.R;
import com.example.leonardo.entregable.fragment.Fragment_receta_detalle;

/**
 * Created by leona on 18/10/2016.
 */

public class Activity_Listado_receta extends AppCompatActivity {
    android.app.FragmentManager AdministradorDeFragments = getFragmentManager();
    FragmentTransaction TransaccionesDeFragments;
    Fragment_receta fragment_receta = new Fragment_receta(new Listener());
    Fragment_receta_detalle MiFraglistado = new Fragment_receta_detalle();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_listado);

        TransaccionesDeFragments = AdministradorDeFragments.beginTransaction();
        TransaccionesDeFragments.replace(R.id.linearFragmentReceta, fragment_receta);
        TransaccionesDeFragments.commit();
    }

    public void VolverListadoReceta (View view){
        setContentView(R.layout.fragment_listado);
        TransaccionesDeFragments = AdministradorDeFragments.beginTransaction();
        TransaccionesDeFragments.replace(R.id.linearFragmentReceta, fragment_receta);
        TransaccionesDeFragments.commit();

    }


    private class Listener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
          setContentView(R.layout.fragment_listado);
          TransaccionesDeFragments = AdministradorDeFragments.beginTransaction();
          TransaccionesDeFragments.replace(R.id.linearFragmentReceta, MiFraglistado);
          TransaccionesDeFragments.commit();
        }
    }


}

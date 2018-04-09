package com.example.leonardo.integrador_fragment_listview;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //Declaro el administrador de transacciones de Fragments
    FragmentManager AdministradorDeFragments = getFragmentManager();
    FragmentTransaction TransaccionesDeFragments;

    //Instancio el Fragment que tiene la funcionalidad del ListView encapsulado
    FragmentListadoProducto MiFragListado = new FragmentListadoProducto();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TransaccionesDeFragments = AdministradorDeFragments.beginTransaction();
        TransaccionesDeFragments.add(R.id.linearPrincipal , MiFragListado);
        TransaccionesDeFragments.commit();

    }
}

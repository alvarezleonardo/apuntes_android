package com.example.leonardo.ejercicio_fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private FragmentManager AdministradorDeFragments = getFragmentManager();
    private FragmentTransaction TransaccionesDeFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MostrarFR (View pview){
        FragmentFondoRojo fragFR = new FragmentFondoRojo();
        TransaccionesDeFragments = AdministradorDeFragments.beginTransaction();
        TransaccionesDeFragments.replace(R.id.linearPrincipal, fragFR);
        TransaccionesDeFragments.commit();

    }

    public void MostrarFV (View pview){
        FragmentFondoVerde fragFV = new FragmentFondoVerde();
        TransaccionesDeFragments = AdministradorDeFragments.beginTransaction();
        TransaccionesDeFragments.replace(R.id.linearPrincipal, fragFV);
        TransaccionesDeFragments.commit();

    }

}

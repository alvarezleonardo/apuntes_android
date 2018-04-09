package com.example.digitalhouse.repasorecycleryfragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentRecyclerRecetas.ComunicadorFragmentActivity {

    private FragmentManager unFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unFragmentManager = getSupportFragmentManager();

        FragmentRecyclerRecetas unFragmentRecyclerRecetas = new FragmentRecyclerRecetas();

        FragmentTransaction unaTransaccion = unFragmentManager.beginTransaction();
        unaTransaccion.replace(R.id.alojadorDeFragment, unFragmentRecyclerRecetas);
        unaTransaccion.commit();


    }

    @Override
    public void clickearonEstaReceta(Receta recetaClickeada) {

        FragmentRecetaDetallada fragmentRecetaDetallada = new FragmentRecetaDetallada();

        Bundle unBundle = new Bundle();

        unBundle.putString("nombre", recetaClickeada.getNombre());
        unBundle.putString("descripcion", recetaClickeada.getDecripcion());
        unBundle.putInt("foto", recetaClickeada.getFoto());

        fragmentRecetaDetallada.setArguments(unBundle);

        FragmentTransaction unaTransaccion = unFragmentManager.beginTransaction();
        unaTransaccion.replace(R.id.alojadorDeFragment, fragmentRecetaDetallada);
        unaTransaccion.commit();

    }
}













package com.example.leolob.ejemplofragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ActividadPrincipal extends AppCompatActivity  implements FragmentListado.AdministradorDeEventosDePeliculas{

    //Declaro el administrador de transacciones de Fragments
    FragmentManager AdministradorDeFragments = getFragmentManager();
    FragmentTransaction TransaccionesDeFragments;

    //Instancio el Fragment que tiene la funcionalidad del ListView encapsulado
    FragmentListado MiFragListado=new FragmentListado();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);

        //Alojo el flujo del ListView (que está encapsulado en un Fragmen)
        //en el holder destinado en el Layout
        TransaccionesDeFragments = AdministradorDeFragments.beginTransaction();
        TransaccionesDeFragments.add(R.id.AlojadorParaLista, MiFragListado);
        TransaccionesDeFragments.commit();
    }

    //Me suscribo al método del Fragment que, al ser callback, me va a informar
    //de qué película tocó.
    @Override
    public void SeSeleccionoUnaPelicula(String Texto) {
        Log.d("ActiviPrincipal", "Texto recibido: "+Texto);

        //Me fijo si existe el alojador para detalle, es decir,
        //si estoy en orientación landscape, ya que en portrait no existe
        if (findViewById(R.id.AlojadorParaDetalle) != null) {

            //Existe, entonces meto ahí el Fragment del detalle
            FragmentDetalle MiFragDetalle=new FragmentDetalle();

            //Le mando un bundle con datos
            Bundle PaqueteDeDatos;
            PaqueteDeDatos=new Bundle();
            PaqueteDeDatos.putString("Titulo", Texto);
            MiFragDetalle.setArguments(PaqueteDeDatos);

            //Instalo el Fragment del detalle en el alojador correspondiente
            TransaccionesDeFragments = AdministradorDeFragments.beginTransaction();
            TransaccionesDeFragments.replace(R.id.AlojadorParaDetalle, MiFragDetalle);
            TransaccionesDeFragments.commit();
        } else {
            //Como NO hay alojador correspondiente, muestro un Toast
            //Si fuera copado, debería mandar a otra Activity para mostrar este detalle
            Toast.makeText(ActividadPrincipal.this, "No hay alojador detalle", Toast.LENGTH_SHORT).show();
        }
    }
}

package com.example.leolob.ejemplofragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by leolob on 1/5/16.
 */
public class FragmentListado extends Fragment {

    AdaptadorDePeliculas MiAdaptador;

    private AdministradorDeEventosDePeliculas _MiAdministradorDeEventos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Declaro la vista que va a devolver el Fragment visible
        View VistaADevolver;
        VistaADevolver = inflater.inflate(R.layout.layout_fragment_dos, container, false);

        //Referencio al ListView
        ListView lstLista;
        lstLista = (ListView) VistaADevolver.findViewById(R.id.ListView_Lista);

        //Declaro e inicializo la lista de peliculas
        ArrayList<Pelicula> ListaDePeliculas=Pelicula.obtenerListaDePeliculas();

        //Declaro e instancio el Adaptador de peliculas,
        //y le asigno el adaptador y el escuchador
        MiAdaptador=new AdaptadorDePeliculas(this.getActivity(), ListaDePeliculas);
        lstLista.setAdapter(MiAdaptador);
        lstLista.setOnItemClickListener(new EscuchadorDePeliculas());

        //Devuelvo la vista ya armada.
        return VistaADevolver;
    }

    //Declaro la clase para el listener
    class EscuchadorDePeliculas implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> Adaptador, View Vista, int Posicion, long ID) {
            Pelicula PeliculaTocada;
            PeliculaTocada=(Pelicula)Adaptador.getItemAtPosition(Posicion);

            Log.d("ClickLista", "Pelicula tocada: "+PeliculaTocada._Titulo);

            //Invoco al método callback, que informa el dato tocado
            _MiAdministradorDeEventos.SeSeleccionoUnaPelicula(PeliculaTocada._Titulo);
        }
    }

    //Creo la clase del Adapter
    class AdaptadorDePeliculas extends BaseAdapter {
        ArrayList<Pelicula> _Datos;
        Context _Contexto;

        //Constructor del Adapter
        public AdaptadorDePeliculas(Context Contexto, ArrayList<Pelicula> ListaDePeliculas) {
            this._Contexto=Contexto;
            this._Datos=ListaDePeliculas;
        }

        @Override
        public int getCount() {
            return this._Datos.size();
        }

        @Override
        public Object getItem(int Posicion) {
            return this._Datos.get(Posicion);
        }

        @Override
        public long getItemId(int Posicion) {
            return Posicion;
        }

        @Override
        public View getView(int PosicionActual, View VistaActual, ViewGroup GrupoActual) {
            LayoutInflater InfladorDeLayouts;
            InfladorDeLayouts=(LayoutInflater)this._Contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            VistaActual=InfladorDeLayouts.inflate(R.layout.elemento_listado_pelicula, GrupoActual, false);

            TextView txtTitulo;
            txtTitulo=(TextView)VistaActual.findViewById(R.id.TextView_Elemento_Lista_Pelicula);

            Pelicula PeliculaSeleccionada;
            PeliculaSeleccionada=(Pelicula)this.getItem(PosicionActual);
            txtTitulo.setText(PeliculaSeleccionada.get_Titulo());

            return VistaActual;

        }
    }

    //Interfase del los eventos del callback
    public interface AdministradorDeEventosDePeliculas {
        public void SeSeleccionoUnaPelicula (String Texto);
    }

    //Enlace entre la activity que invoca al Fragment, y el propio Fragment
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        _MiAdministradorDeEventos = (AdministradorDeEventosDePeliculas) activity;
    }
}



















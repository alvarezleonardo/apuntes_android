package com.example.leonardo.integrador_fragment_listview;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leona on 3/10/2016.
 */

public class FragmentListadoProducto extends Fragment {


    AdaptadorListProductos MiAdaptador;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //Declaro la vista que va a devolver el Fragment visible
        View VistaADevolver;
        VistaADevolver = inflater.inflate(R.layout.fragmen_lista_pelicula, container, false);

        //Referencio al ListView
        ListView lstLista;
        lstLista = (ListView) VistaADevolver.findViewById(R.id.listaPrincipal);

        //Declaro e inicializo la lista de peliculas
        ArrayList<Producto> ListaDeProducto = (ArrayList) Producto.ListProductos();

        //Declaro e instancio el Adaptador de peliculas,
        //y le asigno el adaptador y el escuchador
        MiAdaptador = new AdaptadorListProductos(this.getActivity(), ListaDeProducto);
        lstLista.setAdapter(MiAdaptador);
        //Devuelvo la vista ya armada.
        return VistaADevolver;


    }

}

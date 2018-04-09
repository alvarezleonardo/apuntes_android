package com.example.leolob.ejemplofragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by leolob on 1/5/16.
 */
public class FragmentDetalle extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View VistaADevolver;
        VistaADevolver=inflater.inflate(R.layout.elemento_listado_pelicula, container, false);

        TextView txtTitulo;
        txtTitulo=(TextView)VistaADevolver.findViewById(R.id.TextView_Elemento_Lista_Pelicula);

        Bundle DatosRecibidos;
        DatosRecibidos=getArguments();

        String TituloRecibido;
        TituloRecibido=DatosRecibidos.getString("Titulo");

        txtTitulo.setText("Título: "+TituloRecibido);


        return VistaADevolver;
    }
}

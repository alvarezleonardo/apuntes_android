package com.example.leonardo.entregable.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.leonardo.entregable.R;
import com.example.leonardo.entregable.adapter.AdaptadorDetalleReceta;
import com.example.leonardo.entregable.datos.Receta_detalle;

/**
 * Created by leona on 20/10/2016.
 */

public class Fragment_receta_detalle extends Fragment {
    private AdaptadorDetalleReceta MiAdaptador;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View VistaADevolver;
        VistaADevolver = inflater.inflate(R.layout.listado_detalle_list_receta, container, false);

        ListView lstLista;
        lstLista = (ListView) VistaADevolver.findViewById(R.id.listDetalleReceta);

        MiAdaptador = new AdaptadorDetalleReceta(Receta_detalle.ObtenerRecetaDetalle(2), this.getActivity());
        lstLista.setAdapter(MiAdaptador);
        return VistaADevolver;
    }
}

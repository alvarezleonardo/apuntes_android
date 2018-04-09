package com.example.leonardo.entregable.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leonardo.entregable.adapter.AdaptadorRecycledView;
import com.example.leonardo.entregable.R;
import com.example.leonardo.entregable.datos.Receta;
import com.example.leonardo.entregable.datos.Receta_detalle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leona on 17/10/2016.
 */

public class Fragment_receta extends Fragment {
    private AdaptadorRecycledView adaptadorRecycledView;
    private View.OnClickListener unListener;


    public Fragment_receta(View.OnClickListener unListener) {
        this.unListener = unListener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View vistaADevolver = inflater.inflate(R.layout.listado_receta, container, false);

        RecyclerView recyclerViewReceta = (RecyclerView) vistaADevolver.findViewById(R.id.RecyclerViewReceta);
        adaptadorRecycledView = new AdaptadorRecycledView(this.getActivity(), Receta.ObtenerReceta(), unListener);
        recyclerViewReceta.setAdapter(adaptadorRecycledView);

        LinearLayoutManager linearVertical = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerViewReceta.setLayoutManager(linearVertical);
        recyclerViewReceta.setHasFixedSize(false);

        return vistaADevolver;
    }


}


package com.example.digitalhouse.repasorecycleryfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by digitalhouse on 21/10/16.
 */
public class FragmentRecyclerRecetas extends Fragment {

    private RecyclerView recyclerViewRecetas;
    private AdapterRecetas unAdapterRecetas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View viewADevolver = inflater.inflate(R.layout.fragment_recycler_recetas, container, false);

        recyclerViewRecetas = (RecyclerView) viewADevolver.findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        recyclerViewRecetas.setLayoutManager(linearLayoutManager);

        //ListenerRecetas listener = new ListenerRecetas();
        unAdapterRecetas = new AdapterRecetas(getActivity(), Receta.dameRecetas(), new ListenerRecetas());

        recyclerViewRecetas.setAdapter(unAdapterRecetas);

        return viewADevolver;
    }

    public class ListenerRecetas implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Integer posicionTocada = recyclerViewRecetas.getChildAdapterPosition(view);
            Receta recetaTocada = unAdapterRecetas.getRecetaAtPosition(posicionTocada);

            ComunicadorFragmentActivity unComunicador = (ComunicadorFragmentActivity) getActivity();
            unComunicador.clickearonEstaReceta(recetaTocada);

        }
    }

    public interface ComunicadorFragmentActivity {
        public void clickearonEstaReceta(Receta recetaClickeada);
    }

}






































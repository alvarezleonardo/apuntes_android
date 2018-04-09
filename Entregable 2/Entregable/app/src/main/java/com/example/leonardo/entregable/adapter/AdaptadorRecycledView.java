package com.example.leonardo.entregable.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leonardo.entregable.R;
import com.example.leonardo.entregable.datos.Receta;

import java.util.List;

/**
 * Created by leona on 18/10/2016.
 */

public class AdaptadorRecycledView extends RecyclerView.Adapter implements View.OnClickListener{
    private Context unContexto;
    private List<Receta> unListReceta;
    private View.OnClickListener unListener;

    public AdaptadorRecycledView(Context unContexto, List<Receta> unListReceta, View.OnClickListener unListener) {
        this.unContexto = unContexto;
        this.unListReceta = unListReceta;
        this.unListener = unListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(unContexto);
        View vistaCelda = inflater.inflate(R.layout.items_listado,parent,false);
        vistaCelda.setOnClickListener(unListener);
        RecetaViewHolder receteViewHolder = new RecetaViewHolder(vistaCelda);
        return receteViewHolder;
    }


    @Override
    public void onClick(View view){
        unListener.onClick(view);
    }


    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Receta unaReceta = unListReceta.get(position);
        RecetaViewHolder recetaViewHolder = (RecetaViewHolder) holder;
        recetaViewHolder.CargarReceta(unaReceta);
    }

    @Override
    public int getItemCount() {
        return unListReceta.size();
    }

    private class RecetaViewHolder extends RecyclerView.ViewHolder{
        private TextView textNombreReceta;

        public RecetaViewHolder(View itemView) {
            super(itemView);
            textNombreReceta = (TextView) itemView.findViewById(R.id.textoRecetaListado);
        }
        public void CargarReceta (Receta unaReceta){
            textNombreReceta.setText(unaReceta.getNombre());
        }

    }




}

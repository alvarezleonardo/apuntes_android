package com.example.digitalhouse.repasorecycleryfragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by digitalhouse on 21/10/16.
 */
public class AdapterRecetas extends RecyclerView.Adapter {

    private Context unContexto;
    private List<Receta> listaDeRecetas;
    private View.OnClickListener listener;

    public AdapterRecetas(Context unContexto, List<Receta> listaDeRecetas, View.OnClickListener listener) {
        this.unContexto = unContexto;
        this.listaDeRecetas = listaDeRecetas;
        this.listener = listener;
    }

    public Receta getRecetaAtPosition(Integer position){
        return listaDeRecetas.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(unContexto);
        View viewParaElViewHolder = inflater.inflate(R.layout.detalle_item_receta, parent, false);
        viewParaElViewHolder.setOnClickListener(listener);
        RecetasViewHolder unViewHolderDeRecetas = new RecetasViewHolder(viewParaElViewHolder);
        return unViewHolderDeRecetas;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Receta recetaABindear = listaDeRecetas.get(position);
        RecetasViewHolder unRecetasViewHolder = (RecetasViewHolder) holder;
        unRecetasViewHolder.bindReceta(recetaABindear);
    }

    @Override
    public int getItemCount() {
        return listaDeRecetas.size();
    }

    private class RecetasViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagenReceta;
        private TextView nombreReceta;

        public RecetasViewHolder(View itemView) {
            super(itemView);

            imagenReceta = (ImageView) itemView.findViewById(R.id.imageViewRecetaItem);
            nombreReceta = (TextView) itemView.findViewById(R.id.textNombreRecetaItem);
        }

        public void bindReceta(Receta unaReceta){
            imagenReceta.setImageResource(unaReceta.getFoto());
            nombreReceta.setText(unaReceta.getNombre());
        }

    }















}











package com.example.leonardo.listaconclase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by leona on 26/9/2016.
 */

public class AdapterDetalleLibro extends RecyclerView.Adapter {
    private List<Libro> unaListaDeLibros;
    private Context unContexto;

    public AdapterDetalleLibro(Context pContexto, List<Libro> unaLista) {
        unContexto = pContexto;
        unaListaDeLibros = unaLista;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(unContexto);
        View vistaCelda = inflater.inflate(R.layout.detalle_libro,parent,false);
        LibrosViewHolder librosViewHolder = new LibrosViewHolder(vistaCelda);
        return librosViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Libro unJuguete = unaListaDeLibros.get(position);
        LibrosViewHolder librosViewHolder = (LibrosViewHolder)holder;
        librosViewHolder.cargarLibro(unJuguete);
    }

    public long getItemId(int unElemento){
        return unElemento;
    }

    @Override
    public int getItemCount() {
        return unaListaDeLibros.size();
    }

    private class LibrosViewHolder extends RecyclerView.ViewHolder{
        private TextView TextViewautor;
        private TextView TextViewtitulo;
        private TextView TextViewisbn;
        private TextView TextViewprecio;
        private ImageView ImageViewfoto;


        public LibrosViewHolder(View view) {
            super(view);
            TextViewautor = (TextView)  view.findViewById(R.id.txtAutor);
            TextViewtitulo = (TextView) view.findViewById(R.id.txtTitulo);
            TextViewisbn = (TextView)   view.findViewById(R.id.txtIsbn);
            TextViewprecio = (TextView) view.findViewById(R.id.txtPrecio);
            ImageViewfoto = (ImageView) view.findViewById(R.id.imgFoto);
        }

        public void cargarLibro(Libro unLibro){
            TextViewautor.setText((String) unLibro.getTitulo());
            TextViewtitulo.setText((String) unLibro.getAutor());
            TextViewisbn.setText((String) unLibro.getIsbn());
            TextViewprecio.setText((String) unLibro.getPrecio().toString());
            ImageViewfoto.setImageResource(unLibro.getIdFoto());
        }
    }








}

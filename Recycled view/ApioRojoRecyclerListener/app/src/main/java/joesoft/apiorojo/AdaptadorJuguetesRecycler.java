package joesoft.apiorojo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by joe on 10/6/16.
 */
public class AdaptadorJuguetesRecycler extends RecyclerView.Adapter implements View.OnClickListener {
    private List<Juguete>listaDeJuguetes;
    private Context contexto;
    private View.OnClickListener listener;

    public List<Juguete> getListaDeJuguetes() {
        return listaDeJuguetes;
    }

    public AdaptadorJuguetesRecycler(List<Juguete> listaDeJuguetes, Context contexto, View.OnClickListener listener) {
        this.listaDeJuguetes = listaDeJuguetes;
        this.contexto = contexto;
        this.listener = listener;
    }

    //Aca es donde se crea la vista y el viewHolder
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(contexto);
        View viewDeLaCelda = inflater.inflate(R.layout.celda_juguete,parent,false);

        //LE DECIMOS A CADA CELDA QUE EL QUE LO VA A ESCUCHAR ES EL ADAPTADOR.
        viewDeLaCelda.setOnClickListener(this);
        JuguetesViewHolder juguetesViewHolder = new JuguetesViewHolder(viewDeLaCelda);
        return juguetesViewHolder;
    }

    //Aca es donde al viewholder que contiene la vista le cargo la informacion
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Juguete unJuguete = listaDeJuguetes.get(position);
        JuguetesViewHolder juguetesViewHolder = (JuguetesViewHolder)holder;
        juguetesViewHolder.cargarJuguete(unJuguete);
    }

    @Override
    public int getItemCount() {
        return listaDeJuguetes.size();
    }

    //CUANDO LE HACEN CLICK, LE AVISA AL LISTENER QUE LE PASARON POR PARAMETRO QUE LO TOCARON
    @Override
    public void onClick(View view) {
        listener.onClick(view);
    }


    private class JuguetesViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewNombreJuguete;
        private TextView textViewPlatitaJuguete;

        public JuguetesViewHolder(View view){
            super(view);
            textViewNombreJuguete = (TextView)view.findViewById(R.id.textViewNombreJuguete);
            textViewPlatitaJuguete = (TextView)view.findViewById(R.id.textViewPrecioJuguete);
        }

        public void cargarJuguete(Juguete unJuguete){
            textViewNombreJuguete.setText(unJuguete.getNombre());
            textViewPlatitaJuguete.setText("$"+unJuguete.getPlatita().toString());
        }
    }
}













package joesoft.apiorojo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by joe on 10/11/16.
 */
public class AdaptadorRecyclerDeJuguetes extends RecyclerView.Adapter {
    private Context unContexto;
    private List<Juguete> listaDeJuguetes;

    public AdaptadorRecyclerDeJuguetes(Context unContexto, List<Juguete> listaDeJuguetes) {
        this.unContexto = unContexto;
        this.listaDeJuguetes = listaDeJuguetes;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(unContexto);
        View vistaCelda = inflater.inflate(R.layout.listview_celda_juguete,parent,false);
        JuguetesViewHolder juguetesViewHolder = new JuguetesViewHolder(vistaCelda);
        return juguetesViewHolder;
    }

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


        private class JuguetesViewHolder extends RecyclerView.ViewHolder{
            private TextView textViewNombre;
            private TextView textViewPlatita;

            public JuguetesViewHolder(View view) {
                super(view);
                textViewNombre = (TextView)view.findViewById(R.id.textViewNombreJuguete);
                textViewPlatita = (TextView) view.findViewById(R.id.textViewPrecioJuguete);
            }

            public void cargarJuguete(Juguete unJuguete){
                textViewNombre.setText(unJuguete.getNombre());
                textViewPlatita.setText("$"+unJuguete.getPlatita());
            }
        }
}







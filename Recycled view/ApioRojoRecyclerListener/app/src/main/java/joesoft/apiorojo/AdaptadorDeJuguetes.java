package joesoft.apiorojo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by joe on 10/5/16.
 */
public class AdaptadorDeJuguetes extends BaseAdapter  {
    private List<Juguete> listaDeJuguetes;
    private Context unContext;

    public AdaptadorDeJuguetes(Context context, List<Juguete> listaDeJuguetes) {
        this.listaDeJuguetes = listaDeJuguetes;
        this.unContext = context;
    }


    @Override
    public int getCount() {
        return listaDeJuguetes.size();
    }

    @Override
    public Juguete getItem(int i) {
        return listaDeJuguetes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Juguete jugueteAMostrar = getItem(i);
        ViewHolder viewHolder;

        if(view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) unContext.getSystemService(unContext.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.celda_juguete, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.cargarJuguete(jugueteAMostrar);

        return view;
    }

    private class ViewHolder{
        private TextView textViewNombre;
        private TextView textViewPlatita;

        public ViewHolder(View view){
             textViewNombre = (TextView) view.findViewById(R.id.textViewNombreJuguete);
             textViewPlatita = (TextView) view.findViewById(R.id.textViewPrecioJuguete);
        }

        public void cargarJuguete(Juguete unJuguete){
            textViewNombre.setText(unJuguete.getNombre());
            textViewPlatita.setText("$ " + unJuguete.getPlatita().toString());
        }
    }

}














package com.example.leonardo.entregable.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.leonardo.entregable.R;
import com.example.leonardo.entregable.datos.Receta_detalle;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by leona on 20/10/2016.
 */

public class AdaptadorDetalleReceta extends BaseAdapter {
    private List<Receta_detalle> listaDetalle;
    private Context context;

    public AdaptadorDetalleReceta(List<Receta_detalle> listaDetalle, Context context) {
        this.listaDetalle = listaDetalle;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaDetalle.size();
    }

    @Override
    public Object getItem(int position) {
        return listaDetalle.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater InfladorDeLayouts;
        InfladorDeLayouts=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = InfladorDeLayouts.inflate(R.layout.item_detalle_list_receta, parent, false);

        TextView cantidad = (TextView) convertView.findViewById(R.id.itemCantidad);
        TextView nombre = (TextView) convertView.findViewById(R.id.itemNombre);
        cantidad.setText(listaDetalle.get(position).getCantidad().toString());
        nombre.setText(listaDetalle.get(position).getInsumo());
        return convertView;
    }
}

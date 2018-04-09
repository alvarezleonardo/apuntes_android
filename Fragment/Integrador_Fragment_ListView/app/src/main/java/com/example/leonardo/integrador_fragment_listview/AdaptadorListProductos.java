package com.example.leonardo.integrador_fragment_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by leona on 3/10/2016.
 */

public class AdaptadorListProductos extends BaseAdapter {
    ArrayList<Producto> datos;
    Context contexto;

    //Constructor del Adapter
    public AdaptadorListProductos(Context Contexto, ArrayList<Producto> ListaDeProductos) {
        contexto = Contexto;
        datos = ListaDeProductos;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int Posicion) {
        return datos.get(Posicion);
    }

    @Override
    public long getItemId(int Posicion) {
        return Posicion;
    }

    @Override
    public View getView(int posicionActual, View vistaActual, ViewGroup grupoActual) {
        LayoutInflater InfladorDeLayouts;
        InfladorDeLayouts=(LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        vistaActual = InfladorDeLayouts.inflate(R.layout.item_lista, grupoActual, false);


        TextView nombre = (TextView) vistaActual.findViewById(R.id.nombreProducto);
        TextView precio = (TextView) vistaActual.findViewById(R.id.precioProducto);
        ImageView foto = (ImageView) vistaActual.findViewById(R.id.imagenProducto);

        nombre.setText(datos.get(posicionActual).getNombre());
        precio.setText(datos.get(posicionActual).getPrecio().toString());
        foto.setImageResource(datos.get(posicionActual).getFoto());

        return vistaActual;

    }
}

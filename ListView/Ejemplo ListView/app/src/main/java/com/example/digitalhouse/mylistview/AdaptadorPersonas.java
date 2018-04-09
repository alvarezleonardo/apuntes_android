package com.example.digitalhouse.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by leolob on 10/5/16.
 */
public class AdaptadorPersonas extends BaseAdapter {

    //Atributos necesarios
    private Context unContexto;
    private ArrayList<String> listaDeDatos;

    //Constructor
    public AdaptadorPersonas(Context contexto, ArrayList<String> listaDeDatos) {

        this.unContexto = contexto;
        this.listaDeDatos = listaDeDatos;

    }

    //Metodo obligatorio, en donde me dan la posicion y tiene que devolver el item que esta en esa posicion
    //Si el adapter tiene una lista de otra clase por ejemplo la clase Pelicula.java, hay que reemplazar en la firma
    //del metodo para que devuelva Pelicula en vez de String
    public String getItem(int posicion) {

        return this.listaDeDatos.get(posicion);
    }

    //Metodo obligatorio. Por el momento no es importante, en estos casos el id del item va a ser el mismo numero de su posicion
    public long getItemId(int posicion) {

        return posicion;
    }

    //Metodo obligatorio. Tiene que devolver la cantidad total de elementos que voy a mostrar en la lista
    public int getCount() {

        return this.listaDeDatos.size();
    }

    //Metodo obligatorio y el mas importante. Este metodo debe "inflar" un xml para transformarlo en una View,
    //modificar esta View, y retornarla.
    public View getView(int posicionActual, View vistaActual, ViewGroup grupoActual) {

        //Busco un LayoutInflater, le pido al contexto que me traiga el servicio del sistema llamado "LAYOUT_INFLATER_SERVICE"
        LayoutInflater miInfladorDeLayouts;
        miInfladorDeLayouts = (LayoutInflater) this.unContexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Le cambio el valor a la vista actual que me mandan como parametro, y lo igualo al resultado de inflater.inflate
        //del xml layout_detalle.El termino "inflar" se refiere a agarrar un xml y transformarlo en un objeto de tipo View.
        //Esto nos sirve para poder modificar sus componentes como los textviews y luego retornarlo ya modificado.
        vistaActual = miInfladorDeLayouts.inflate(R.layout.layout_detalle, grupoActual, false);
        //Los otros parametros del metodo inflate son el grupoActual que recibo como parametro y false.(para el 99% de los casos)


        //Busco el textview que quiero modificar con el metodo de siempre (findViewById) y le cambio el texto (setText)
        TextView txtNombre;
        txtNombre = (TextView) vistaActual.findViewById(R.id.TextView_Nombre_Persona);

        //En este caso como tenia una lista de Strings, solo necesite obtener el String que estaba en la posicion
        //que me pasaron por parametro
        txtNombre.setText(getItem(posicionActual));

        //Retorno la vista que infle ya modificada
        return vistaActual;

    }

}








































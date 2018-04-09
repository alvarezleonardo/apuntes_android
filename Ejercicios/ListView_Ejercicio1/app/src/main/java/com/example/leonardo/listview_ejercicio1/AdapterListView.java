package com.example.leonardo.listview_ejercicio1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by leona on 22/9/2016.
 */

public class AdapterListView extends BaseAdapter   {
    private Context ctxContextoAusar;
    private List lstListaAusar;
    public AdapterListView(Context unContexto, List unaLista){
        ctxContextoAusar = unContexto;
        lstListaAusar = unaLista;
    }

    public View getView(int unElemento, View unaVista, ViewGroup unGrupoDeVista){

        LayoutInflater inflater = (LayoutInflater)  ctxContextoAusar.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View item = inflater.inflate(R.layout.detalle_listview_contactos, unGrupoDeVista, false);


        TextView nombre = (TextView) item.findViewById(R.id.listViewContacto);
        nombre.setText((String) lstListaAusar.get(unElemento));

        // Devolvemos la vista para que se muestre en el ListView.
        return item;
   }

    public long getItemId(int unElemento){
        return unElemento;
    }

    public String getItem(int unElemento){
        return (String) lstListaAusar.get(unElemento);
    }
    public int getCount(){
        return lstListaAusar.size();
    }


}

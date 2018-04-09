package com.example.digitalhouse.parserbase.controller;

import android.content.Context;
import android.provider.CalendarContract;

import com.example.digitalhouse.parserbase.dao.DaoCanales;
import com.example.digitalhouse.parserbase.model.Canales;
import com.example.digitalhouse.parserbase.util.ResultListener;

import java.util.List;

/**
 * Created by leona on 26/10/2016.
 */

public class CanalesController {
    private ResultListener<List<Canales>> listener;

    public void getCanales(Context context, final ResultListener<List<Canales>> listenerFromView){
        DaoCanales dao = new DaoCanales();
        listener = listenerFromView;

        dao.obtenerCanalesJSON(context, new ResultListenerNewsController());
    }

    private class ResultListenerNewsController implements ResultListener<List<Canales>>{

        @Override
        public void finish(List<Canales> resultado) {

            //CUANDO EL DAO LE AVISA QUE TERMINO, EL CONTROLLER NOTIFICA A LA VIEW.
            listener.finish(resultado);
        }
    }


}

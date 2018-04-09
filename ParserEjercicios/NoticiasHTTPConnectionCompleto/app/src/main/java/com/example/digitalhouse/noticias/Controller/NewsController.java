package com.example.digitalhouse.noticias.Controller;

import android.content.Context;

import com.example.digitalhouse.noticias.DAO.NewsDAO;
import com.example.digitalhouse.noticias.Model.News;
import com.example.digitalhouse.noticias.utils.ResultListener;

/**
 * Created by digitalhouse on 19/10/16.
 */
public class NewsController {

    private ResultListener<News> listener;

    public void obtenerNoticia(Context context, final ResultListener<News> listenerFromView) {
        //PEDIRLE AL DAO UNA NOTICIA
        NewsDAO newsDAO = new NewsDAO();
        listener = listenerFromView;
        //SE SUSCRIBE AL DAO PARA QUE LE AVISE CUANDO TERMINO DE PROCESAR EL PEDIDO
        newsDAO.obtenerNoticiaDesdeJSON(context, new ResultListenerNewsController());
    }

    private class ResultListenerNewsController implements ResultListener<News>{
        @Override
        public void finish(News resultado) {
            //CUANDO EL DAO LE AVISA QUE TERMINO, EL CONTROLLER NOTIFICA A LA VIEW.
            listener.finish(resultado);
        }
    }
}

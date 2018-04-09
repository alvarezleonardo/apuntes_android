package com.example.digitalhouse.noticias.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.digitalhouse.noticias.Controller.NewsController;
import com.example.digitalhouse.noticias.Model.News;
import com.example.digitalhouse.noticias.R;
import com.example.digitalhouse.noticias.utils.ResultListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadNews(View view){

        //PEDIR NOTICIA AL CONTROLADOR
        NewsController newsController = new NewsController();

        //LA VIEW SE SUSCRIBE AL CONTROLLER PARA QUE LE AVISE ALGO
        newsController.obtenerNoticia(MainActivity.this, new ResultListenerNews());

        Toast.makeText(MainActivity.this, "Loading", Toast.LENGTH_SHORT).show();
    }

    private class ResultListenerNews implements ResultListener<News>{

        @Override
        public void finish(News resultado) {
            //ESTE CODIGO SE EJECUTA CUANDO EL CONTROLLER LO NOTIFICA (EN ESTE CASO SOLO MUESTRA LA NOTICIA)
            Toast.makeText(MainActivity.this, resultado.toString(), Toast.LENGTH_SHORT).show();
        }
    }













}

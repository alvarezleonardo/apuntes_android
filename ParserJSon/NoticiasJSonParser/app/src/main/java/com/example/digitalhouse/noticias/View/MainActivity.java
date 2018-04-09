package com.example.digitalhouse.noticias.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.digitalhouse.noticias.Controller.NewsController;
import com.example.digitalhouse.noticias.Model.News;
import com.example.digitalhouse.noticias.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadNews(View view){

        //PEDIR NOTICIA AL CONTROLADOR
        NewsController newsController = new NewsController();
        News news = newsController.obtenerNoticia(MainActivity.this);

        //MUESTRA LA NOTICIA
        Toast.makeText(MainActivity.this, news.toString(), Toast.LENGTH_SHORT).show();
    }
}

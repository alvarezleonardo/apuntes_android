package com.ejemplo.noticias.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ejemplo.noticias.R;
import com.ejemplo.noticias.controller.NewsController;
import com.ejemplo.noticias.model.News;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadNewsClick(View view){

        NewsController newsController = new NewsController();
        News news = newsController.getNews(this);

    }
}

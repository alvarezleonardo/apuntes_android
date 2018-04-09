package com.example.digitalhouse.parserbase.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.digitalhouse.parserbase.R;
import com.example.digitalhouse.parserbase.controller.CanalesController;
import com.example.digitalhouse.parserbase.dao.DaoCanales;
import com.example.digitalhouse.parserbase.model.Canales;
import com.example.digitalhouse.parserbase.model.Contenedor;
import com.example.digitalhouse.parserbase.util.ResultListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void loadNewsClick(View view) {
        CanalesController unControl = new CanalesController();
        unControl.getCanales(this, new ResultListenerNews());
    }

    private class ResultListenerNews implements ResultListener<List<Canales>> {

        @Override
        public void finish(List<Canales> resultado) {
            List<Canales> unaListaCanales = resultado;

            Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
        }
    }




}

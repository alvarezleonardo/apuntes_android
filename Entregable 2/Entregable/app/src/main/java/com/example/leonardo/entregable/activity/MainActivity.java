package com.example.leonardo.entregable.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.leonardo.entregable.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostrar_fotos (View view){
        Intent unIntent = new Intent(MainActivity.this, Activity_Foto_Fragment.class);
        startActivity(unIntent);

    }
    public void mostrar_receta (View view){
        Intent unIntent = new Intent(MainActivity.this, Activity_Listado_receta.class);
        startActivity(unIntent);

    }


}

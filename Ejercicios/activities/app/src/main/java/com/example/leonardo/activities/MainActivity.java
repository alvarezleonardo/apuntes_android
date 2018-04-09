package com.example.leonardo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void IniciarActivity (View view){
        //crear un intent, intenta mostrar el activity
        Intent unIntent = new Intent(MainActivity.this, SecondActivity.class);

        //Como pasar parametros, se comporta como un diccionario
        Bundle unBundle = new Bundle();
        unBundle.putInt("Entero", 2);
        unBundle.putString("Mensaje", "Hola");

        unIntent.putExtras(unBundle);
        startActivity(unIntent);
    }

}

package com.example.leonardo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Obtener intent
        Intent unIntent = getIntent();

        //obtener bundle

        Bundle unBundle = unIntent.getExtras();

        String unMensajeRecibido = unBundle.getString("Mensaje");
        Toast.makeText(SecondActivity.this, unMensajeRecibido, Toast.LENGTH_SHORT).show();
    }



}

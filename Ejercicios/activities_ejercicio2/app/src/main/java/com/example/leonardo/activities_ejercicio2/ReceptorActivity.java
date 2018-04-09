package com.example.leonardo.activities_ejercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceptorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptor);

        Intent unIntent = getIntent();
        Bundle unBundle = unIntent.getExtras();

        TextView unNombre = (TextView) findViewById(R.id.edtDatoNombre);
        TextView unApellido = (TextView) findViewById(R.id.edtDatoApellido);
        TextView unaEdad = (TextView) findViewById(R.id.edtDatoEdad);


        unNombre.setText(unBundle.getString("Nombre"));
        unApellido.setText(unBundle.getString("Apellido"));
        unaEdad.setText(unBundle.getString("Edad"));


    }
}

package com.example.leonardo.activities_ejercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
    }
    public void EnviarDatos (View view){
        EditText unNombre = (EditText) findViewById(R.id.edtNombre);
        EditText unApellido = (EditText) findViewById(R.id.edtApellido);
        EditText unaEdad = (EditText) findViewById(R.id.edtEdad);

        Intent unIntent = new Intent(this, ReceptorActivity.class);
        Bundle unBundle = new Bundle();

        unBundle.putString("Nombre", String.valueOf(unNombre.getText()));
        unBundle.putString("Apellido", String.valueOf(unApellido.getText()));
        unBundle.putString("Edad", String.valueOf(unaEdad.getText()));

        unIntent.putExtras(unBundle);
        startActivity(unIntent);
    }
}

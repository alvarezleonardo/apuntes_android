package com.example.digitalhouse.comunicacionentreactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Bundle unBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toast.makeText(SecondActivity.this, "Creacion Act2", Toast.LENGTH_SHORT).show();

        //OBTENEMOS EL INTENT
        Intent unIntent = getIntent();

        //OBTENEMOS EL BUNDLE
        Bundle unBundle = unIntent.getExtras();

        //Obtenemos el mensaje
        String unMensajeRecibido = unBundle.getString("Mensaje");

        //Imprimo el mensaje
        Toast.makeText(SecondActivity.this, unMensajeRecibido, Toast.LENGTH_SHORT).show();

    }

  /*  @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(SecondActivity.this, "Start Act2", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(SecondActivity.this, "Destroy Act2", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(SecondActivity.this, "Resume Act2", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(SecondActivity.this, "Stop Act2", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(SecondActivity.this, "Pause Act2", Toast.LENGTH_SHORT).show();
    }*/
}

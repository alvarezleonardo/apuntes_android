package com.example.digitalhouse.comunicacionentreactivities;

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
        Toast.makeText(MainActivity.this, "Creacion Primer Act", Toast.LENGTH_SHORT).show();
    }

    public void iniciarNuevaActivity(View view) {

        //CREAR UN INTENT
        Intent unIntent = new Intent(MainActivity.this, SecondActivity.class);

        //CREO UN BUNDLE
        Bundle unBundle = new Bundle();

        //CARGO INFORMACION EN EL BUNDLE
        unBundle.putString("Mensaje", "Hello Activity 2");
        unBundle.putInt("Entero", 2);

        //Asocio el bundle con el Intent
        unIntent.putExtras(unBundle);

        startActivity(unIntent);
    }

/*
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "Start Act1", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "Destroy Act1", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "Resume Act1", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "Stop Act1", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "Pause Act1", Toast.LENGTH_SHORT).show();
    }*/
}

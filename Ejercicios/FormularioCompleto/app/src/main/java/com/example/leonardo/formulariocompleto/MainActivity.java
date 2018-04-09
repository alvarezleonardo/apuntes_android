package com.example.leonardo.formulariocompleto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Comenzar(){
        Intent unIntent = new Intent(this, FormularioActivity.class);
        startActivity(unIntent);

    }
}

package com.example.leonardo.activities_ejercicio1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void EnviarDatos (View view){
        EditText unEditor = (EditText) findViewById(R.id.EditorTexto);
        Intent unIntent = new Intent(this, RecepatorActivity.class);
        Bundle unBundle = new Bundle();
        unIntent.putExtras(unBundle);

        unBundle.putString("Mensaje", String.valueOf(unEditor.getText()));
        unIntent.putExtras(unBundle);
        startActivity(unIntent);
    }
}

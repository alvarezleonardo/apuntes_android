package com.example.leonardo.activities_ejercicio1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RecepatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepator);

        Intent unIntent = getIntent();
        Bundle unBundle = unIntent.getExtras();

        TextView unTextView = (TextView) findViewById(R.id.TextView);
        unTextView.setText(unBundle.getString("Mensaje"));

    }
}

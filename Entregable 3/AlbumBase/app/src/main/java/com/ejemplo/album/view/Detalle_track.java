package com.ejemplo.album.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.ejemplo.album.R;

public class Detalle_track extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_track);

        Intent unIntent = getIntent();
        Bundle unBundle = unIntent.getExtras();
        String detalle = unBundle.getString("Detalle");
        TextView txtdetalle = (TextView) findViewById(R.id.detalleTrack);
        txtdetalle.setText(detalle);
        //Toast.makeText(Detalle_track.this, detalle, Toast.LENGTH_SHORT).show();

    }
}

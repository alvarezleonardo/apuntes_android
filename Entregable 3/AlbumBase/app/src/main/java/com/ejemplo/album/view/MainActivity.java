package com.ejemplo.album.view;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.ejemplo.album.R;
import com.ejemplo.album.controller.TrackController;
import com.ejemplo.album.model.Track;

import java.util.List;

import util.ResultListener;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterTrack adapterTrack;
    private TrackController trackController ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewTrack);


        adapterTrack = new AdapterTrack(this, new ListenerTrack());
        recyclerView.setAdapter(adapterTrack);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


        trackController = new TrackController();

        //Este metodo va a pedirle al postcontroller que busque los posts y tambien actualizar el adaptador del recyclerView
        trackController.getAllTrack(this, new ResultListener<List<Track>>() {
            @Override
            public void finish(List<Track> resultado) {
                adapterTrack.setTrackList(resultado);
                adapterTrack.notifyDataSetChanged();
            }
        });

    }

    public class ListenerTrack implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Integer posicionTocada = recyclerView.getChildAdapterPosition(view);
            Track trackTocada = adapterTrack.getTrackAtPosition(posicionTocada);
            Bundle unBundle = new Bundle();
            unBundle.putString("Detalle", trackTocada.getTitle());

            Intent unIntent = new Intent(MainActivity.this, Detalle_track.class);
            unIntent.putExtras(unBundle);

            startActivity(unIntent);
        }
    }
}












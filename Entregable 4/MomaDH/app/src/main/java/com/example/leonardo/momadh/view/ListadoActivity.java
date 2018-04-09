package com.example.leonardo.momadh.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.leonardo.momadh.R;
import com.example.leonardo.momadh.controller.ArtistControler;
import com.example.leonardo.momadh.dao.DAOartist;
import com.example.leonardo.momadh.model.Artists;
import com.example.leonardo.momadh.model.Paints;
import com.example.leonardo.momadh.model.ResultListener;

import java.util.List;

public class ListadoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterRecycled adapterRecycled;
    private DAOartist daoArtist ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        recyclerView = (RecyclerView) findViewById(R.id.recycledView);


        adapterRecycled = new AdapterRecycled(this, new ListenerArtist());
        recyclerView.setAdapter(adapterRecycled);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArtistControler.getAllArtist(this, new ResultListener<List<Paints>>() {
            @Override
            public void finish(List<Paints> resultado) {
                adapterRecycled.setPaintsList(resultado);
                adapterRecycled.notifyDataSetChanged();
            }

        });

    }

    public class ListenerArtist implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Integer posicionTocada = recyclerView.getChildAdapterPosition(view);
            Paints PaintTocado = adapterRecycled.getPaintAtPosition(posicionTocada);

            Bundle unBundle = new Bundle();
            unBundle.putString("NAMEIMG", PaintTocado.getName());
            unBundle.putString("IMG", PaintTocado.getImage());
            unBundle.putString("PINTOR", PaintTocado.getArtists().getName());

            Intent unIntent = new Intent(ListadoActivity.this, DetalleActivity.class);
            unIntent.putExtras(unBundle);

            startActivity(unIntent);
        }
    }

}

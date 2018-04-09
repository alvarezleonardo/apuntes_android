package joesoft.apiorojo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Juguete> listaDeJuguetes = new ArrayList<>();

        listaDeJuguetes.add(new Juguete("Rambo",20));
        listaDeJuguetes.add(new Juguete("Superman",20));
        listaDeJuguetes.add(new Juguete("Seiya",20));
        listaDeJuguetes.add(new Juguete("yoyo",20));
        listaDeJuguetes.add(new Juguete("tutu",20));
        listaDeJuguetes.add(new Juguete("Ben Diez",20));
        listaDeJuguetes.add(new Juguete("Pikachu",20));
        listaDeJuguetes.add(new Juguete("Max Steel",20));
        listaDeJuguetes.add(new Juguete("Barbie",20));
        listaDeJuguetes.add(new Juguete("LudoMatic",20));
        listaDeJuguetes.add(new Juguete("Hot Wheels",20));
        listaDeJuguetes.add(new Juguete("Muñeca System",20));
        listaDeJuguetes.add(new Juguete("Rambo",20));
        listaDeJuguetes.add(new Juguete("Superman",20));
        listaDeJuguetes.add(new Juguete("Seiya",20));
        listaDeJuguetes.add(new Juguete("yoyo",20));
        listaDeJuguetes.add(new Juguete("tutu",20));
        listaDeJuguetes.add(new Juguete("Ben Diez",20));
        listaDeJuguetes.add(new Juguete("Pikachu",20));
        listaDeJuguetes.add(new Juguete("Max Steel",20));
        listaDeJuguetes.add(new Juguete("Barbie",20));
        listaDeJuguetes.add(new Juguete("LudoMatic",20));
        listaDeJuguetes.add(new Juguete("Hot Wheels",20));
        listaDeJuguetes.add(new Juguete("Muñeca System",20));
        listaDeJuguetes.add(new Juguete("Rambo",20));
        listaDeJuguetes.add(new Juguete("Superman",20));
        listaDeJuguetes.add(new Juguete("Seiya",20));
        listaDeJuguetes.add(new Juguete("yoyo",20));
        listaDeJuguetes.add(new Juguete("tutu",20));
        listaDeJuguetes.add(new Juguete("Ben Diez",20));
        listaDeJuguetes.add(new Juguete("Pikachu",20));
        listaDeJuguetes.add(new Juguete("Max Steel",20));
        listaDeJuguetes.add(new Juguete("Barbie",20));
        listaDeJuguetes.add(new Juguete("LudoMatic",20));
        listaDeJuguetes.add(new Juguete("Hot Wheels",20));
        listaDeJuguetes.add(new Juguete("Muñeca System",20));
        listaDeJuguetes.add(new Juguete("Rambo",20));
        listaDeJuguetes.add(new Juguete("Superman",20));
        listaDeJuguetes.add(new Juguete("Seiya",20));
        listaDeJuguetes.add(new Juguete("yoyo",20));
        listaDeJuguetes.add(new Juguete("tutu",20));
        listaDeJuguetes.add(new Juguete("Ben Diez",20));
        listaDeJuguetes.add(new Juguete("Pikachu",20));
        listaDeJuguetes.add(new Juguete("Max Steel",20));
        listaDeJuguetes.add(new Juguete("Barbie",20));
        listaDeJuguetes.add(new Juguete("LudoMatic",20));
        listaDeJuguetes.add(new Juguete("Hot Wheels",20));
        listaDeJuguetes.add(new Juguete("Muñeca System",20));

        RecyclerView recyclerViewJuguetes = (RecyclerView) findViewById(R.id.listViewJuguetes);

        AdaptadorRecyclerDeJuguetes adaptadorDeJuguetes = new AdaptadorRecyclerDeJuguetes(this,listaDeJuguetes);

        recyclerViewJuguetes.setAdapter(adaptadorDeJuguetes);

        LinearLayoutManager linearVertical = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewJuguetes.setLayoutManager(linearVertical);

        recyclerViewJuguetes.setHasFixedSize(true);


    }













}

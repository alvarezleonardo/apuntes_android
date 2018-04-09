package joesoft.apiorojo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewJuguetes;
    private AdaptadorJuguetesRecycler adaptadorJuguetesRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Juguete> listaDeJuguetes = new ArrayList<>();

        listaDeJuguetes.add(new Juguete("Maestro",20));
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
        listaDeJuguetes.add(new Juguete("Maestro Yoda",20));

        //Aca es donde obtengo el recycler view
//        ListView listViewJuguetes = (ListView)findViewById(R.id.listViewJuguetes);
        recyclerViewJuguetes = (RecyclerView)findViewById(R.id.recyclerViewJuguetes);

        //Le decios que no va a variar el tamanio de la lista
        recyclerViewJuguetes.setHasFixedSize(true);

        //Le pedimos que muestre las cosas en forma de lista
        recyclerViewJuguetes.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //Le pedimos que muestre las cosas en forma de grilla
        recyclerViewJuguetes.setLayoutManager(new GridLayoutManager(this,2));

        //Creamos el adaptador del recycler
//        AdaptadorDeJuguetes adaptadorDeJuguetes = new AdaptadorDeJuguetes(this,listaDeJuguetes);
        ListenerToast unListenerToast = new ListenerToast();
        adaptadorJuguetesRecycler = new AdaptadorJuguetesRecycler(listaDeJuguetes,this, unListenerToast);

        //Le damos el adapter al Recycler
//        listViewJuguetes.setAdapter(adaptadorDeJuguetes);
        recyclerViewJuguetes.setAdapter(adaptadorJuguetesRecycler);
    }

    //LISTENER PARA EL RECYCLER VIEW
    private class ListenerToast implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "Hola", Toast.LENGTH_SHORT).show();
        }
    }
}











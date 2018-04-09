package com.example.leonardo.listaconclase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Libro> unArrayDeLibros = Libro.obtenerLibro();
    //private AdapterDetalleLibro adaptadorVista = new AdapterDetalleLibro(this, unArrayDeLibros);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView unaLista = (ListView) findViewById(R.id.lstListaLibros);
        AdapterDetalleLibro adaptadorVista = new AdapterDetalleLibro(this, unArrayDeLibros);
        unaLista.setAdapter(adaptadorVista);
        escuchadorDeLibros unEscuchador = new escuchadorDeLibros();
        unaLista.setOnItemClickListener(unEscuchador);
    }

    private class escuchadorDeLibros implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> referencia, View unaVista, int posicionTocada, long iDPosicionTocada) {
            Libro unLibroTocado = (Libro) referencia.getItemAtPosition(posicionTocada);

            Toast.makeText(MainActivity.this, "Titulo tocado: "+ unLibroTocado.getTitulo(), Toast.LENGTH_SHORT).show();

            Intent unIntent = new Intent(MainActivity.this, LibroCompleto.class);

            Bundle unBundle = new Bundle();
            unBundle.putString("Titulo", unLibroTocado.getTitulo());
            unBundle.putString("Autor", unLibroTocado.getAutor() );
            unBundle.putString("ISBN", unLibroTocado.getIsbn());
            unBundle.putString("Precio", unLibroTocado.getPrecio().toString());


            unIntent.putExtras(unBundle);


            startActivity(unIntent);


        }
    }



}

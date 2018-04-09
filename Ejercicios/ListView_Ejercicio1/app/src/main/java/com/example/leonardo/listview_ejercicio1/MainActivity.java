package com.example.leonardo.listview_ejercicio1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private List<String> lstListaAUsar = unaListaDeContactos();
    private AdapterListView adaptadorVista = new AdapterListView(this, lstListaAUsar);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView unaLista = (ListView) findViewById(R.id.lstListaContacto);
        unaLista.setAdapter(adaptadorVista);
        actualizarContador();
    }
    private void actualizarContador(){
        TextView unText = (TextView) findViewById(R.id.txtCantidadElementos);
        unText.setText("Cantidad de Elementos: " + lstListaAUsar.size());
    }

    public List<String> unaListaDeContactos(){
        List<String> unaLista = new ArrayList<>();
        unaLista.add("Leonardo Alvarez");
        unaLista.add("Manuela Pedraza");
        unaLista.add("Julian Alvarez");
        unaLista.add("Federico Teran");
        unaLista.add("Ursula Alvarez");
        unaLista.add("Erika Fahsbender");
        unaLista.add("Patricia Giordani");
        unaLista.add("Nicolasa Baena");
        return unaLista;
    }

    public void AgregarContacto(View view){
        EditText nombreParaAgregar = (EditText) findViewById(R.id.edtNombrePersona);

        //Toast.makeText(this, nombreParaAgregar.getText().toString(), Toast.LENGTH_SHORT).show();
        if(nombreParaAgregar.getText().toString().isEmpty()){
           Toast.makeText(this, "Debe ingresar un nombre correcto", Toast.LENGTH_SHORT).show();
        }else{
            lstListaAUsar.add(nombreParaAgregar.getText().toString());
            Toast.makeText(this, "Agregado correctamente", Toast.LENGTH_SHORT).show();
            actualizarContador();
            nombreParaAgregar.setText("");
        }
        adaptadorVista.notifyDataSetChanged();
    }
}

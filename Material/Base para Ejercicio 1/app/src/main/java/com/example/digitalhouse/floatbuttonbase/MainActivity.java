package com.example.digitalhouse.floatbuttonbase;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentConTodo.ComunicadorEntreFragment{

    private FragmentManager miFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miFragmentManager = getFragmentManager();

        FragmentConTodo unFragmentConTodo = new FragmentConTodo();

        FragmentTransaction unaTransaccion = miFragmentManager.beginTransaction();
        unaTransaccion.replace(R.id.contenedorDeFragments, unFragmentConTodo);
        unaTransaccion.commit();

    }

    @Override
    public void notificarClickActivity(String mensaje) {
        if(mensaje.isEmpty()){
            Toast.makeText(this, "No puede ser vacio", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Enviado correctamente", Toast.LENGTH_SHORT).show();
        }

    }
}

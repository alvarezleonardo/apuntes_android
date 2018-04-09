package com.example.leonardo.sumador_restador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Integer resultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Restar (View vista){
        resultado -= 1;
        TextView unText = (TextView) findViewById(R.id.resultado);
        unText.setText(resultado.toString());
    }

    public void Sumar (View vista){
        resultado += 1;
        TextView unText = (TextView) findViewById(R.id.resultado);
        unText.setText(resultado.toString());

    }


}

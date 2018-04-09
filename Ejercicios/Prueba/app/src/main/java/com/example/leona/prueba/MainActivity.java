package com.example.leona.prueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "ON CREATE", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "ON RESUME", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this, "ON RESTART", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "ON START", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "ON PAUSE", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "ON STOP", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "ON DESTROY", Toast.LENGTH_SHORT).show();

    }

    public void botonApretado(View view){
        LinearLayout unLinearLayout = (LinearLayout) findViewById(R.id.LinearLayoutPrincipal);
        unLinearLayout.setBackgroundResource(R.color.colorLayoutP);
       //Toast.makeText(this, "Hola mundo", Toast.LENGTH_LONG).show();
        //TextView textviewNombre = (TextView) findViewById(R.id.textViewNombre);
        //textviewNombre.setText("Prueba amigo");
    }
    public void botonApretadoDos(View view){
        TextView unTextView = (TextView) findViewById(R.id.textViewNombre);

        unTextView.setTextColor(getResources().getColor(R.color.colorLayoutP));

    }
    public void botonApretadoTres(View view) {
        TextView unTextView = (TextView) findViewById(R.id.textViewNombre);

        unTextView.setText("Vamos Carajo");
    }
}
package com.example.leonardo.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginregister);
    }
    public void VerificarLogin (View view){


        EditText datoDeUsuario = (EditText) findViewById(R.id.edtusername);
        Intent unIntent = new Intent(this, LoginLogueado.class);
        Bundle unBundle = new Bundle();
        unBundle.putString("Usuario", String.valueOf(datoDeUsuario.getText()));
        unIntent.putExtras(unBundle);
        startActivity(unIntent);


    }
    public void IrRegistrar(View view){
        Intent unIntent = new Intent(this, Register.class);
        startActivity(unIntent);
    }
}

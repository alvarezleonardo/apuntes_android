package com.example.leonardo.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void RegistrarUser (View view){
        EditText password = (EditText) findViewById(R.id.edtRegisterPassword);
        EditText repassword = (EditText) findViewById(R.id.edtPasswordConfirm);
        if(password.getText().toString().equals(repassword.getText().toString())){
            Intent principal = new Intent(this, LoginRegister.class);
            startActivity(principal);
            finish();
        }else{

            Toast.makeText(this, "error en contraseña", Toast.LENGTH_SHORT).show();
        }

    }
}

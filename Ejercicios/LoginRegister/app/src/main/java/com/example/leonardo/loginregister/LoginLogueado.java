package com.example.leonardo.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginLogueado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_logueado);
        Intent unIntent = getIntent();
        Bundle unBundle = unIntent.getExtras();

        TextView unText = (TextView) findViewById(R.id.txtdatosdelogin);
        unText.setText("Welcome " + unBundle.getString("Usuario") + "!");
    }
}

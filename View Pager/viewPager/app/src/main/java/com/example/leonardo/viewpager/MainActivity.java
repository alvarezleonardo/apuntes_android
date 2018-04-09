package com.example.leonardo.viewpager;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager framentManager = getSupportFragmentManager();
        AdaptadorViewPager adaptadorViewPager = new AdaptadorViewPager(framentManager);

        ViewPager viewPager = (ViewPager) findViewById(R.id.mostrarViewPager);

        viewPager.setAdapter(adaptadorViewPager);

    }
}

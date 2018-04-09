package com.example.leonardo.entregable.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.leonardo.entregable.adapter.AdaptadorViewPager;
import com.example.leonardo.entregable.R;

/**
 * Created by leona on 17/10/2016.
 */

public class Activity_Foto_Fragment extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_page_foto);

        FragmentManager fragmentManager = getSupportFragmentManager();
        AdaptadorViewPager adaptadorViewPager = new AdaptadorViewPager(fragmentManager);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPagerVisorFoto);
        viewPager.setAdapter(adaptadorViewPager);
    }
}

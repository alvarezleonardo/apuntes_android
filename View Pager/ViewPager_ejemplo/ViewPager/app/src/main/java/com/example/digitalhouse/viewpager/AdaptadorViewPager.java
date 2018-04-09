package com.example.digitalhouse.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by digitalhouse on 13/10/16.
 */
public class AdaptadorViewPager extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;

    public AdaptadorViewPager(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<>();

        Integer color = 0xFF0000FF;
        for(Integer i = 0; i < 25; i++){

            fragmentList.add(FragmentColor.dameUnFragmentDeColor(color));
            color += 20;
        }




     /*

        FragmentColor fragmentColor1 = new FragmentColor();
        Bundle bundle1 = new Bundle();
        bundle1.putInt("Color", 0xFF0000FF);
        fragmentColor1.setArguments(bundle1);
        fragmentList.add(fragmentColor1);


        FragmentColor fragmentColor2 = new FragmentColor();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("Color", 0xFFFF0000);
        fragmentColor2.setArguments(bundle2);
        fragmentList.add(fragmentColor2);*/


    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}

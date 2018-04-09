package com.example.leonardo.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leona on 13/10/2016.
 */

public class AdaptadorViewPager extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList;

    public AdaptadorViewPager(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<>();
        fragmentList.add(new FragmentAzul());
        fragmentList.add(new FragmentVerde());
        fragmentList.add(new FragmentRojo());

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

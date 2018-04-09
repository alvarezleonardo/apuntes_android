package com.example.leonardo.entregable.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.leonardo.entregable.R;
import com.example.leonardo.entregable.fragment.Fragment_foto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leona on 17/10/2016.
 */

public class AdaptadorViewPager extends FragmentStatePagerAdapter {
    private List<Fragment> listaFragment;


    public AdaptadorViewPager(FragmentManager fm) {
        super(fm);
        listaFragment = new ArrayList<>();
        listaFragment.add(Fragment_foto.DameUnFragmentFoto(R.drawable.astridygaston, "Astrid y Gastón ", "Lima, Perú"));
        listaFragment.add(Fragment_foto.DameUnFragmentFoto(R.drawable.borago, "Boragó", "Santiago, Chile"));
        listaFragment.add(Fragment_foto.DameUnFragmentFoto(R.drawable.central, "Central", "Lima, Perú"));
        listaFragment.add(Fragment_foto.DameUnFragmentFoto(R.drawable.dom, "D.O.M.", "San Pablo, Brasil"));
        listaFragment.add(Fragment_foto.DameUnFragmentFoto(R.drawable.maido, "Maido", "Lima, Perú"));
        listaFragment.add(Fragment_foto.DameUnFragmentFoto(R.drawable.mani, "Maní", "San Pablo, Brasil"));
        listaFragment.add(Fragment_foto.DameUnFragmentFoto(R.drawable.quintonil, "Quintonil", "Ciudad de México"));
        listaFragment.add(Fragment_foto.DameUnFragmentFoto(R.drawable.tegui, "Tegui", "Buenos Aires, Argentina"));
    }

    @Override

    public Fragment getItem(int position) {
        return listaFragment.get(position);
    }

    @Override
    public int getCount() {
        return listaFragment.size();
    }
}

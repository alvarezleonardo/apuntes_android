package com.example.digitalhouse.viewpager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by digitalhouse on 13/10/16.
 */
public class FragmentColor extends Fragment {


    public static FragmentColor dameUnFragmentDeColor(Integer color){
        FragmentColor fragmentColor = new FragmentColor();
        Bundle bundle = new Bundle();
        bundle.putInt("Color", color);
        fragmentColor.setArguments(bundle);

        return fragmentColor;
    }

     @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_azul, container, false);

        Bundle bundle = getArguments();
        Integer color = bundle.getInt("Color");
        view.setBackgroundColor(color);

        return view;
    }
}

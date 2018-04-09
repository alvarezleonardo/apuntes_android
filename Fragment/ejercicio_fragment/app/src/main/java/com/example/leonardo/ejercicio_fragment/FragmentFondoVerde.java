package com.example.leonardo.ejercicio_fragment;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentFondoVerde.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentFondoVerde#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentFondoVerde extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        return inflater.inflate(R.layout.fragment_fragment_fondo_verde, container, false);
    }


}

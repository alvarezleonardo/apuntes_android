package com.example.leonardo.entregable.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leonardo.entregable.R;

/**
 * Created by leona on 17/10/2016.
 */

public class Fragment_foto extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public static Fragment_foto DameUnFragmentFoto(Integer idFoto, String localidad, String provincia){
        Fragment_foto fragmentFoto = new Fragment_foto();
        Bundle bundle = new Bundle();
        bundle.putInt("FOTO", idFoto);
        bundle.putString("LOCALIDAD", localidad);
        bundle.putString("PROVINCIA", provincia);
        fragmentFoto.setArguments(bundle);
        return fragmentFoto;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_foto, container, false);

        ImageView foto = (ImageView) view.findViewById(R.id.foto);
        TextView localidad = (TextView) view.findViewById(R.id.relativeFotoLocalidad);
        TextView provincia = (TextView) view.findViewById(R.id.relativeFotoProvincia);

        Bundle bundle = getArguments();

        foto.setImageResource(bundle.getInt("FOTO"));
        localidad.setText(bundle.getString("LOCALIDAD"));
        provincia.setText(bundle.getString("PROVINCIA"));

        return view;
    }
}



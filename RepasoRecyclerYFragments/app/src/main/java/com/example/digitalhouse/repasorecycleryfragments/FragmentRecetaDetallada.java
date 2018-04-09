package com.example.digitalhouse.repasorecycleryfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by digitalhouse on 21/10/16.
 */
public class FragmentRecetaDetallada extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View viewADevolverInflado = inflater.inflate(R.layout.fragment_receta_detallada, container, false);

        TextView textViewNombre = (TextView) viewADevolverInflado.findViewById(R.id.textViewNombreDetallada);
        TextView textViewDescripcion = (TextView) viewADevolverInflado.findViewById(R.id.textViewDescripcionDetallada);
        ImageView imageViewFoto = (ImageView) viewADevolverInflado.findViewById(R.id.imageViewRecetaDetallada);

        Bundle bundleRecibido = getArguments();

        String nombreRecibido = bundleRecibido.getString("nombre");
        String descripcionRecibida = bundleRecibido.getString("descripcion");
        Integer fotoRecibida = bundleRecibido.getInt("foto");

        textViewNombre.setText(nombreRecibido);
        textViewDescripcion.setText(descripcionRecibida);
        imageViewFoto.setImageResource(fotoRecibida);

        return viewADevolverInflado;

    }
}

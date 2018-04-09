package com.example.digitalhouse.floatbuttonbase;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by andres on 04/10/16.
 */
public class FragmentConTodo extends Fragment {
    private TextInputLayout editTextMensajeSanta;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_con_todo, container, false);

        FloatingActionButton button = (FloatingActionButton) view.findViewById(R.id.floatinActionButton);
        editTextMensajeSanta = (TextInputLayout) view.findViewById(R.id.inputLayoutMensaje);

        button.setOnClickListener(new FABclickListener());

        return view;

    }

    private class FABclickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            ComunicadorEntreFragment unComunicador = (ComunicadorEntreFragment) getActivity();
            unComunicador.notificarClickActivity(editTextMensajeSanta.getEditText().getText().toString());
            //Toast.makeText(getActivity(), "Click", Toast.LENGTH_SHORT).show();
        }
    }

    public interface ComunicadorEntreFragment {
        public void notificarClickActivity(String mensaje);
    }


}


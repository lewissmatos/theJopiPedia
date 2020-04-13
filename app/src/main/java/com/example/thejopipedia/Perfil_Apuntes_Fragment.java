package com.example.thejopipedia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class Perfil_Apuntes_Fragment extends Fragment implements View.OnClickListener {

    private ImageView añadir_nota, done;
    private TextView txt_añadir;
    private EditText encabezado, apunte;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil__apuntes_, container, false);

        añadir_nota = view.findViewById(R.id.añadir_nota);
        done = view.findViewById(R.id.done);
        encabezado = view.findViewById(R.id.encabezado);
        apunte = view.findViewById(R.id.apunte);

        añadir_nota.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.añadir_nota:
            encabezado.setVisibility(View.VISIBLE);
            apunte.setVisibility(View.VISIBLE);
            done.setVisibility(View.VISIBLE);
            break;
            case R.id.done:
        }
    }
}

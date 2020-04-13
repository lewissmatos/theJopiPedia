package com.example.thejopipedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thejopipedia.RecylclerViewAdapter.RecyclerViewAdapterNota;

import java.util.ArrayList;


public class Perfil_Apuntes_Fragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewAdapterNota adapter;
    private ImageView añadir_nota;
    private EditText encabezado, contenido;
    private ArrayList<Notas> notas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil__apuntes_, container, false);

        añadir_nota = view.findViewById(R.id.añadir_nota);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        encabezado = view.findViewById(R.id.encabezado);
        contenido = view.findViewById(R.id.contenido);

        añadir_nota.setOnClickListener(this);

        notas = new ArrayList<>();

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.añadir_nota:
                startActivity(new Intent(getContext(), ApuntesActivity.class));
                break;
        }
    }
}

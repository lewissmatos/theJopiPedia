package com.example.thejopipedia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thejopipedia.RecylclerViewAdapter.Tabla;
import com.example.thejopipedia.RecylclerViewAdapter.TablaRecylclerViewAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class PuntuacionFragment extends Fragment {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private RecyclerView recyclerView3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.puntuacion_fragment, container, false);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        recyclerView3 = view.findViewById(R.id.recyclerView3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView3.setAdapter(new TablaRecylclerViewAdapter(getTablaList(), getContext()));


        return view;
    }

    private ArrayList<Tabla> getTablaList(){
        ArrayList<Tabla> tabla = new ArrayList<>();

        tabla.add(new Tabla(R.drawable.gold_medal_96px, R.string.pos1, "0000", R.color.gold));
        tabla.add(new Tabla(R.drawable.silver_medal_96px, R.string.pos2, "0000", R.color.silver));
        tabla.add(new Tabla(R.drawable.bronze_medal_96px, R.string.pos3, "0000", R.color.bronze));
        tabla.add(new Tabla(R.drawable.medal_96px, R.string.pos4, "0000", R.color.gris_tabla));
        tabla.add(new Tabla(R.drawable.medal_96px, R.string.pos5, "0000", R.color.gris_tabla));
        tabla.add(new Tabla(R.drawable.medal_96px, R.string.pos6, "0000", R.color.gris_tabla));
        tabla.add(new Tabla(R.drawable.medal_96px, R.string.pos7, "0000", R.color.gris_tabla));
        tabla.add(new Tabla(R.drawable.medal_96px, R.string.pos8, "0000", R.color.gris_tabla));

        return tabla;
    }
}

package com.example.thejopipedia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thejopipedia.RecylclerViewAdapter.Perfil;
import com.example.thejopipedia.RecylclerViewAdapter.PerfilRecylclerViewAdapter;
import com.example.thejopipedia.RecylclerViewAdapter.Tabla;
import com.example.thejopipedia.RecylclerViewAdapter.TablaRecylclerViewAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class PuntuacionFragment extends Fragment {

    //private TextView p1, p2, p3, p4, p5, p6, p7, p8, Points1,Points2,Points3,Points4,Points5,Points6, Points7, Points8;
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

        tabla.add(new Tabla(R.drawable.gold_medal_96px, R.string.pos1, R.string.p1, R.color.gold));
        tabla.add(new Tabla(R.drawable.silver_medal_96px, R.string.pos2, R.string.p2, R.color.silver));
        tabla.add(new Tabla(R.drawable.bronze_medal_96px, R.string.pos3, R.string.p3, R.color.bronze));
        tabla.add(new Tabla(R.drawable.medal_96px, R.string.pos4, R.string.p4, R.color.gris_tabla));
        tabla.add(new Tabla(R.drawable.medal_96px, R.string.pos5, R.string.p5, R.color.gris_tabla));
        tabla.add(new Tabla(R.drawable.medal_96px, R.string.pos6, R.string.p6, R.color.gris_tabla));
        tabla.add(new Tabla(R.drawable.medal_96px, R.string.pos7, R.string.p7, R.color.gris_tabla));
        tabla.add(new Tabla(R.drawable.medal_96px, R.string.pos8, R.string.p8, R.color.gris_tabla));

        return tabla;
    }
}

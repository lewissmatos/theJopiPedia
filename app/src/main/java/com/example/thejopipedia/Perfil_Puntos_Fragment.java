package com.example.thejopipedia;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.thejopipedia.RecylclerViewAdapter.Perfil;
import com.example.thejopipedia.RecylclerViewAdapter.PerfilRecylclerViewAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class Perfil_Puntos_Fragment extends Fragment {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    private RecyclerView recyclerView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil__puntos_, container, false);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        recyclerView2 = view.findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView2.setAdapter(new PerfilRecylclerViewAdapter(getPerfilList(), getContext()));
        return view;
    }
    private ArrayList<Perfil> getPerfilList(){
        ArrayList<Perfil> perfil = new ArrayList<>();

        perfil.add(new Perfil(R.drawable.bio_dna_128, R.string.bio, R.string.puntbio, R.color.bioclaro));
        perfil.add(new Perfil(R.drawable.galaxy_128, R.string.univ, R.string.puntuniv, R.color.univclaro));
        perfil.add(new Perfil(R.drawable.anim_128, R.string.zoo, R.string.puntzoo, R.color.zooclaro));
        perfil.add(new Perfil(R.drawable.think_128, R.string.filo,R.string.puntfilo, R.color.filoclaro));
        perfil.add(new Perfil(R.drawable.atom_128, R.string.fis, R.string.puntfis, R.color.fisclaro));
        perfil.add(new Perfil(R.drawable.globe_128, R.string.geo, R.string.puntgeo, R.color.geoclaro));
        perfil.add(new Perfil(R.drawable.computer_128, R.string.comp, R.string.puntcomp, R.color.compclaro));
        perfil.add(new Perfil(R.drawable.test_128, R.string.quim, R.string.puntquim, R.color.quimclaro));
        perfil.add(new Perfil(R.drawable.num_128, R.string.mat, R.string.puntmat, R.color.matclaro));
        perfil.add(new Perfil(R.drawable.sword_128, R.string.his, R.string.punthis, R.color.hisclaro));
        perfil.add(new Perfil(R.drawable.green_book_128, R.string.lit,R.string.puntlit, R.color.litclaro));
        perfil.add(new Perfil(R.drawable.temple_128, R.string.mit, R.string.puntmit, R.color.relclaro));

        return perfil;

    }
}

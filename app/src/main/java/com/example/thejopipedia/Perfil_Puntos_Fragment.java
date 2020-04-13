package com.example.thejopipedia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        perfil.add(new Perfil(R.drawable.bio_dna_128, R.string.bio, "0000", R.color.bioclaro));
        perfil.add(new Perfil(R.drawable.galaxy_128, R.string.univ, "0000", R.color.univclaro));
        perfil.add(new Perfil(R.drawable.anim_128, R.string.zoo, "0000", R.color.zooclaro));
        perfil.add(new Perfil(R.drawable.think_128, R.string.filo,"0000", R.color.filoclaro));
        perfil.add(new Perfil(R.drawable.atom_128, R.string.fis, "0000", R.color.fisclaro));
        perfil.add(new Perfil(R.drawable.globe_128, R.string.geo, "0000", R.color.geoclaro));
        perfil.add(new Perfil(R.drawable.computer_128, R.string.comp, "0000", R.color.compclaro));
        perfil.add(new Perfil(R.drawable.test_128, R.string.quim, "0000", R.color.quimclaro));
        perfil.add(new Perfil(R.drawable.num_128, R.string.mat, "0000", R.color.matclaro));
        perfil.add(new Perfil(R.drawable.sword_128, R.string.his, "0000", R.color.hisclaro));
        perfil.add(new Perfil(R.drawable.purple_book, R.string.lit,"0000", R.color.litclaro));
        perfil.add(new Perfil(R.drawable.temple_128, R.string.mit, "0000", R.color.relclaro));

        return perfil;

    }
}

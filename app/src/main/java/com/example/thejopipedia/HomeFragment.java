package com.example.thejopipedia;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thejopipedia.RecylclerViewAdapter.RecylclerViewAdapter;
import com.example.thejopipedia.RecylclerViewAdapter.Tema;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    AlertDialog.Builder opdialog;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        mAuth = FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference();

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(new RecylclerViewAdapter(getTemasList(), getContext()));

        opdialog = new AlertDialog.Builder(getContext());

        return view;
    }

    @Override
    public void onClick(View v) {
    }

    private ArrayList<Tema> getTemasList(){
        ArrayList<Tema> temas = new ArrayList<>();

        temas.add(new Tema(R.drawable.bio_dna_128, R.string.bio, R.string.d1, R.color.bio99));
        temas.add(new Tema(R.drawable.galaxy_128, R.string.univ, R.string.d2, R.color.univ99));
        temas.add(new Tema(R.drawable.anim_128, R.string.zoo, R.string.d3, R.color.zoo99));
        temas.add(new Tema(R.drawable.think_128, R.string.filo, R.string.d4, R.color.filo99));
        temas.add(new Tema(R.drawable.atom_128, R.string.fis, R.string.d5, R.color.fis99));
        temas.add(new Tema(R.drawable.globe_128, R.string.geo, R.string.d6, R.color.geo99));
        temas.add(new Tema(R.drawable.computer_128, R.string.comp, R.string.d7, R.color.comp99));
        temas.add(new Tema(R.drawable.test_128, R.string.quim, R.string.d8, R.color.quim99));
        temas.add(new Tema(R.drawable.num_128, R.string.mat, R.string.d9, R.color.mat99));
        temas.add(new Tema(R.drawable.sword_128, R.string.his, R.string.d10, R.color.his99));
        temas.add(new Tema(R.drawable.purple_book, R.string.lit, R.string.d11, R.color.lit99));
        temas.add(new Tema(R.drawable.temple_128, R.string.mit, R.string.d12, R.color.mit99));

        return temas;
    }

}

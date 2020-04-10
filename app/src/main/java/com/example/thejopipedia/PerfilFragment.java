package com.example.thejopipedia;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thejopipedia.RecylclerViewAdapter.Perfil;
import com.example.thejopipedia.RecylclerViewAdapter.PerfilRecylclerViewAdapter;
import com.example.thejopipedia.RecylclerViewAdapter.RecylclerViewAdapter;
import com.example.thejopipedia.RecylclerViewAdapter.Tema;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PerfilFragment extends Fragment implements View.OnClickListener {
    private TextView txtNom, txtUser;

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private Button btnLogOut;
    AlertDialog.Builder opdialog;
    private RecyclerView recyclerView2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.perfil_fragment, container, false);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        txtNom = view.findViewById(R.id.txtNom);
        txtUser = view.findViewById(R.id.txtUser);
        btnLogOut = view.findViewById(R.id.btnLogOut);

        btnLogOut.setOnClickListener(this);

        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String nombre = dataSnapshot.child("Nombre").getValue().toString();
                txtNom.setText(nombre);
                String email = dataSnapshot.child("Email").getValue().toString();
                txtUser.setText(email);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

        recyclerView2 = view.findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView2.setAdapter(new PerfilRecylclerViewAdapter(getPerfilList(), getContext()));

        return view;

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogOut:
                opdialog=new AlertDialog.Builder(getContext());
                    opdialog.setMessage("¿Deseas cerrar sesion?")
                        .setTitle("ADVERTENCIA")
                        .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mAuth.signOut();
                                startActivity(new Intent(getContext(), MainActivity.class));
                            }
                        }).setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                opdialog.create();
                opdialog.show();
                break;
        }
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
        perfil.add(new Perfil(R.drawable.test_128, R.string.quim, R.string.quim, R.color.quimclaro));
        perfil.add(new Perfil(R.drawable.num_128, R.string.mat, R.string.puntmat, R.color.matclaro));
        perfil.add(new Perfil(R.drawable.sword_128, R.string.his, R.string.punthis, R.color.hisclaro));
        perfil.add(new Perfil(R.drawable.green_book_128, R.string.lit,R.string.puntlit, R.color.litclaro));
        perfil.add(new Perfil(R.drawable.temple_128, R.string.mit, R.string.puntmit, R.color.relclaro));

        return perfil;
    }
}
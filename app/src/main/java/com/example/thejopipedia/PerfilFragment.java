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
import androidx.viewpager.widget.ViewPager;

import com.example.thejopipedia.RecylclerViewAdapter.Perfil;
import com.example.thejopipedia.RecylclerViewAdapter.PerfilRecylclerViewAdapter;
import com.example.thejopipedia.RecylclerViewAdapter.RecylclerViewAdapter;
import com.example.thejopipedia.RecylclerViewAdapter.Tema;
import com.example.thejopipedia.RecylclerViewAdapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
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
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.perfil_fragment, container, false);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        txtNom = view.findViewById(R.id.txtNom);
        txtUser = view.findViewById(R.id.txtUser);
        btnLogOut = view.findViewById(R.id.btnLogOut);

        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);

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

        viewPager.setAdapter(new ViewPagerAdapter(getFragmentManager(), tabLayout.getTabCount()));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
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

}
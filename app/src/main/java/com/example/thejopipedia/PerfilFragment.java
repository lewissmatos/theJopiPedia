package com.example.thejopipedia;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.thejopipedia.RecylclerViewAdapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class PerfilFragment extends Fragment implements View.OnClickListener {
    private TextView txtNom, txtUser;

    private Button btnLogOut;
    AlertDialog.Builder opdialog;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Window window;
    private ViewPagerAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.perfil_fragment, container, false);

        //-----------------------------------


        txtNom = view.findViewById(R.id.txtNom);
        txtUser = view.findViewById(R.id.txtUser);
        btnLogOut = view.findViewById(R.id.btnLogOut);
        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);
        btnLogOut.setOnClickListener(this);

        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(), tabLayout.getTabCount()));

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
                    opdialog.setMessage(R.string.desea_cerrar)
                        .setTitle(R.string.advertencia)
                        .setPositiveButton(R.string.aceptar_sesion, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getContext(), MainActivity.class));
                            }
                        }).setNegativeButton(R.string.cancelar_sesion, new DialogInterface.OnClickListener() {
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
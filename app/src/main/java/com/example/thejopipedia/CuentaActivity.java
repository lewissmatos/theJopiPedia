package com.example.thejopipedia;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.thejopipedia.RecylclerViewAdapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class CuentaActivity extends AppCompatActivity implements OnClickListener {

    private TextView txtNom, txtUser;

    private Button btnLogOut;
    AlertDialog.Builder opdialog;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Window window;
    private ViewPagerAdapter adapter;
    ImageView btnVolver;
    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);

        String colorbarra = "#454550";

        this.window = getWindow();
        //barcolor
        window.setStatusBarColor(Color.parseColor(colorbarra));

        user = Preferences.getUserData(this);

        txtNom = findViewById(R.id.txtNom);
        txtUser = findViewById(R.id.txtUser);
        btnLogOut = findViewById(R.id.btnLogOut);
        btnVolver = findViewById(R.id.btnVolver);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        btnLogOut.setOnClickListener(this);
        btnVolver.setOnClickListener(this);

        txtNom.setText(user.getNombre());
        txtUser.setText(user.getCorreo());



        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount()));

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
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogOut:
                opdialog = new AlertDialog.Builder(this, R.style.DialogBasicCustomNormal);
                opdialog.setMessage(R.string.desea_cerrar)
                        .setIcon(R.drawable.advertencia)
                        .setTitle(R.string.advertencia)
                        .setPositiveButton(R.string.aceptar_sesion, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Preferences.SaveUserData(CuentaActivity.this, " ", " ", " ", " ");
                                startActivity(new Intent(CuentaActivity.this, MainActivity.class));
                                finish();
                            }
                        }).setNegativeButton(R.string.cancelar_sesion, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                opdialog.create();
                opdialog.show();
                break;
            case R.id.btnVolver:
                startActivity(new Intent(this, Main2Activity.class));
                finish();
                break;
        }
    }
}
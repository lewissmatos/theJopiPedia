package com.example.thejopipedia;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BiologiaActivity extends AppCompatActivity implements View.OnClickListener{
    LinearLayout lyPrin;
    Button btnPlay;
    ImageView btnVolver;
    private int id;
    TextView txtTitulo;
    ImageView img;
    private Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biologia);

        try {
            Bundle b = getIntent().getExtras();
            id = b.getInt("id");
        } catch (Exception e){}

        //FIND VIEW ID
        btnPlay = findViewById(R.id.btnPlay);
        btnVolver = findViewById(R.id.btnVolver);
        txtTitulo = findViewById(R.id.txtTitulo);
        lyPrin = findViewById(R.id.lyPrin);
        img = findViewById(R.id.img);
        //ONCLICS
        btnPlay.setOnClickListener(this);
        btnVolver.setOnClickListener(this);
        getBundle(id);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.btnVolver):
                startActivity(new Intent(this, Main2Activity.class));
                finish();
                break;
            case (R.id.btnPlay):
                Toast.makeText(getApplicationContext(), R.string.prox, Toast.LENGTH_SHORT).show();
        }
    }

    private void getBundle(int id){
        switch (id) {

            case 0:
                lyPrin.setBackgroundTintList(getResources().getColorStateList(R.color.bio99));
                txtTitulo.setText(R.string.bio);
                img.setImageResource(R.drawable.bio_dna_128);
                btnPlay.setBackgroundResource(R.drawable.btnplaybio);
                //---------------------------------------------------------
                String barraBio = "#99FBA53A";
                this.window = getWindow();
                //barcolor
                window.setStatusBarColor(Color.parseColor(barraBio));

                break;
            case 1:
                lyPrin.setBackgroundTintList(getResources().getColorStateList(R.color.univ99));
                txtTitulo.setText(R.string.univ);
                img.setImageResource(R.drawable.galaxy_128);
                btnPlay.setBackgroundResource(R.drawable.btnplayuniv);
                //---------------------------------------------------------
                 String barraUniv = "#995F9E98";
                this.window = getWindow();
                //barcolor
                window.setStatusBarColor(Color.parseColor(barraUniv));
                break;
            case 2:
                lyPrin.setBackgroundTintList(getResources().getColorStateList(R.color.zoo99));
                txtTitulo.setText(R.string.zoo);
                img.setImageResource(R.drawable.anim_128);
                btnPlay.setBackgroundResource(R.drawable.btnplayzoo);
                //---------------------------------------------------------
                String barraZoo = "#99D8AA65";
                this.window = getWindow();
                //barcolor
                window.setStatusBarColor(Color.parseColor(barraZoo));
                break;
            case 3:
                lyPrin.setBackgroundTintList(getResources().getColorStateList(R.color.filo99));
                txtTitulo.setText(R.string.filo);
                img.setImageResource(R.drawable.think_128);
                btnPlay.setBackgroundResource(R.drawable.btnplayfilo);
                //---------------------------------------------------------
                String barraFilo = "#99637785";
                this.window = getWindow();
                //barcolor
                window.setStatusBarColor(Color.parseColor(barraFilo));
                break;
            case 4:
                lyPrin.setBackgroundTintList(getResources().getColorStateList(R.color.fis99));
                txtTitulo.setText(R.string.fis);
                img.setImageResource(R.drawable.atom_128);
                btnPlay.setBackgroundResource(R.drawable.btnplayfis);
                //---------------------------------------------------------
                String barraFis = "#99F3859B";
                this.window = getWindow();
                //barcolor
                window.setStatusBarColor(Color.parseColor(barraFis));
                break;
            case 5:
                txtTitulo.setTextColor(getResources().getColor(R.color.geo99));
                txtTitulo.setText(R.string.geo);
                img.setImageResource(R.drawable.globe_128);
                btnPlay.setBackgroundResource(R.drawable.curvas_marron);
                //---------------------------------------------------------
                String barraGeo = "#9969EDA1";
                this.window = getWindow();
                //barcolor
                window.setStatusBarColor(Color.parseColor(barraGeo));
                break;
            case 6:
                lyPrin.setBackgroundTintList(getResources().getColorStateList(R.color.comp99));
                txtTitulo.setText(R.string.comp);
                img.setImageResource(R.drawable.computer_128);
                btnPlay.setBackgroundResource(R.drawable.btnplaycomp);
                //---------------------------------------------------------
                String barraComp = "#996B837E";
                this.window = getWindow();
                //barcolor
                window.setStatusBarColor(Color.parseColor(barraComp));
                break;
            case 7:
                lyPrin.setBackgroundTintList(getResources().getColorStateList(R.color.quim99));
                txtTitulo.setText(R.string.quim);
                img.setImageResource(R.drawable.test_128);
                btnPlay.setBackgroundResource(R.drawable.btnplayquim);
                //---------------------------------------------------------
                String barraQuim = "#990490D1";
                this.window = getWindow();
                //barcolor
                window.setStatusBarColor(Color.parseColor(barraQuim));
                break;
            case 8:
                txtTitulo.setTextColor(getResources().getColor(R.color.mat99));
                txtTitulo.setText(R.string.mat);
                img.setImageResource(R.drawable.num_128);
                btnPlay.setBackgroundResource(R.drawable.btnplaymat);
                //---------------------------------------------------------
                String barraMat = "#995734A5";
                this.window = getWindow();
                //barcolor
                window.setStatusBarColor(Color.parseColor(barraMat));
                break;
            case 9:
                lyPrin.setBackgroundTintList(getResources().getColorStateList(R.color.his99));
                txtTitulo.setText(R.string.his);
                img.setImageResource(R.drawable.sword_128);
                btnPlay.setBackgroundResource(R.drawable.curvas_amarillas);
                //---------------------------------------------------------
                String barraHis = "#99DFE651";
                this.window = getWindow();
                //barcolor
                window.setStatusBarColor(Color.parseColor(barraHis));
                break;
            case 10:
                lyPrin.setBackgroundTintList(getResources().getColorStateList(R.color.lit99));
                txtTitulo.setText(R.string.lit);
                img.setImageResource(R.drawable.green_book_128);
                btnPlay.setBackgroundResource(R.drawable.btnplaylit);
                //---------------------------------------------------------
                String barraLit = "#9989EACE";
                this.window = getWindow();
                //barcolor
                window.setStatusBarColor(Color.parseColor(barraLit));
                break;
            case 11:
                lyPrin.setBackgroundTintList(getResources().getColorStateList(R.color.rel99));
                txtTitulo.setText(R.string.mit);
                img.setImageResource(R.drawable.temple_128);
                btnPlay.setBackgroundResource(R.drawable.btnplayrel);
                //---------------------------------------------------------
                String barraMit = "#99454545";
                this.window = getWindow();
                //barcolor
                window.setStatusBarColor(Color.parseColor(barraMit));
                break;
        }
    }
}

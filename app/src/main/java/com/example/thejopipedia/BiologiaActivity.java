package com.example.thejopipedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BiologiaActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnVolver, btnPlay;
    private int id;
    TextView txtTitulo;
    ImageView img;

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
        switch (id){

            case 0:
                txtTitulo.setTextColor(getResources().getColor(R.color.bio99));
                txtTitulo.setText(R.string.bio);
                img.setImageResource(R.drawable.bio_dna_128);
                btnPlay.setBackgroundResource(R.drawable.btnplaybio);
                break;
            case 1:
                txtTitulo.setTextColor(getResources().getColor(R.color.univ99));
                txtTitulo.setText(R.string.univ);
                img.setImageResource(R.drawable.galaxy_128);
                btnPlay.setBackgroundResource(R.drawable.btnplayuniv);
                break;
            case 2:
                txtTitulo.setTextColor(getResources().getColor(R.color.zoo99));
                txtTitulo.setText(R.string.zoo);
                img.setImageResource(R.drawable.anim_128);
                btnPlay.setBackgroundResource(R.drawable.btnplayzoo);
                break;
            case 3:
                txtTitulo.setTextColor(getResources().getColor(R.color.filo99));
                txtTitulo.setText(R.string.filo);
                img.setImageResource(R.drawable.think_128);
                btnPlay.setBackgroundResource(R.drawable.btnplayfilo);
                break;
            case 4:
                txtTitulo.setTextColor(getResources().getColor(R.color.fis99));
                txtTitulo.setText(R.string.fis);
                img.setImageResource(R.drawable.atom_128);
                btnPlay.setBackgroundResource(R.drawable.btnplayfis);
                break;
            case 5:
                txtTitulo.setTextColor(getResources().getColor(R.color.geo99));
                txtTitulo.setText(R.string.geo);
                img.setImageResource(R.drawable.globe_128);
                btnPlay.setBackgroundResource(R.drawable.curvas_marron);
                break;
            case 6:
                txtTitulo.setTextColor(getResources().getColor(R.color.comp99));
                txtTitulo.setText(R.string.comp);
                img.setImageResource(R.drawable.computer_128);
                btnPlay.setBackgroundResource(R.drawable.btnplaycomp);
                break;
            case 7:
                txtTitulo.setTextColor(getResources().getColor(R.color.quim99));
                txtTitulo.setText(R.string.quim);
                img.setImageResource(R.drawable.test_128);
                btnPlay.setBackgroundResource(R.drawable.btnplayquim);
                break;
            case 8:
                txtTitulo.setTextColor(getResources().getColor(R.color.mat99));
                txtTitulo.setText(R.string.mat);
                img.setImageResource(R.drawable.num_128);
                btnPlay.setBackgroundResource(R.drawable.btnplaymat);
                break;
            case 9:
                txtTitulo.setTextColor(getResources().getColor(R.color.his99));
                txtTitulo.setText(R.string.his);
                img.setImageResource(R.drawable.sword_128);
                btnPlay.setBackgroundResource(R.drawable.curvas_amarillas);
                break;
            case 10:
                txtTitulo.setTextColor(getResources().getColor(R.color.lit99));
                txtTitulo.setText(R.string.lit);
                img.setImageResource(R.drawable.green_book_128);
                btnPlay.setBackgroundResource(R.drawable.btnplaylit);
                break;
            case 11:
                txtTitulo.setTextColor(getResources().getColor(R.color.rel99));
                txtTitulo.setText(R.string.mit);
                img.setImageResource(R.drawable.temple_128);
                btnPlay.setBackgroundResource(R.drawable.btnplayrel);
                break;
        }
    }
}

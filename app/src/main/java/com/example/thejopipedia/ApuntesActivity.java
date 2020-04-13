package com.example.thejopipedia;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ApuntesActivity extends AppCompatActivity implements View.OnClickListener {

    AlertDialog.Builder opdialog;
    private Window window;
    ImageView btnVolver, btnListo;
    EditText encabezado, contenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apuntes);

        String colorbarra = "#383E40";

        this.window = getWindow();
        //barcolor
        window.setStatusBarColor(Color.parseColor(colorbarra));

        encabezado = findViewById(R.id.encabezado);
        contenido= findViewById(R.id.contenido);
        btnVolver= findViewById(R.id.btnVolver);
        btnListo= findViewById(R.id.btnListo);

        btnVolver.setOnClickListener(this);
        btnListo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnVolver:
                if (! encabezado.equals("") || !contenido.equals("")){
                    opdialog = new AlertDialog.Builder(this);
                    opdialog.setMessage("Desea salir sin guardar")
                            .setTitle(R.string.advertencia)
                            .setPositiveButton(R.string.aceptar_sesion, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    startActivity(new Intent(ApuntesActivity.this, CuentaActivity.class));
                                    finish();
                                }
                            }).setNegativeButton(R.string.cancelar_sesion, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    opdialog.create();
                    opdialog.show();
                }
                break;
            case R.id.btnListo:
        }
    }
}

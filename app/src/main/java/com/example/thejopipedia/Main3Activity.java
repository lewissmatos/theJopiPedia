package com.example.thejopipedia;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    private ProgressDialog dialog;
    private Button btnReg;
    private EditText edUser, edPass, edRPass, edNom;
    private String us, pass, mat, nom, rpass;
    ImageView btnVolver;
    private Window window;
    @Override
    @SuppressLint("SourceLockedOrientationActivity")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        String colorbarra = "#69BD76";

        this.window = getWindow();
        //barcolor
        window.setStatusBarColor(Color.parseColor(colorbarra));

        // Initialize Firebase Auth
        //FIND VIEW ID
        btnVolver = findViewById(R.id.btnVolver);
        btnReg = findViewById(R.id.btnReg);
        edUser = findViewById(R.id.edUser);
        edNom = findViewById(R.id.edNom);
        edPass = findViewById(R.id.edPass);
        edRPass= findViewById(R.id.edRPass);

        dialog=new ProgressDialog(this);

        //ONCLICS
        btnReg.setOnClickListener(this);
        btnVolver.setOnClickListener(this);
        btnVolver.setOnClickListener(this);
        edUser.setOnClickListener(this);
        edNom.setOnClickListener(this);
        edPass.setOnClickListener(this);
        edRPass.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnVolver:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.btnReg:
                dialog.setMessage("Registrando usuario");
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                us=edUser.getText().toString();
                nom=edNom.getText().toString();
                pass=edPass.getText().toString();
                rpass=edRPass.getText().toString();
                if (us.isEmpty()||pass.isEmpty()||nom.isEmpty()||rpass.isEmpty())
                {
                    dialog.dismiss();
                    Toast.makeText(this, R.string.llenar_campos, Toast.LENGTH_SHORT).show();
                }
                else {
                    if (edPass.length() < 6) {
                        dialog.dismiss();
                        Toast.makeText(this, R.string.contr_6_car, Toast.LENGTH_SHORT).show();
                    } else {

                    }
                    break;
                }
        }
    }

}

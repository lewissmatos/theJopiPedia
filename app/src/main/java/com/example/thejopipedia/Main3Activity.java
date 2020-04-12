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
    private FirebaseAuth mAuth;
    private ProgressDialog dialog;
    private DatabaseReference mDatabase;
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

        mAuth = FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference();

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
                    }
                    else {
                    if (!edPass.getText().toString().equals(edRPass.getText().toString())) {
                        dialog.dismiss();
                        Toast.makeText(this, R.string.contr_no_coin, Toast.LENGTH_SHORT).show();
                        }

                    else {
                        mAuth.createUserWithEmailAndPassword(us, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Map<String, Object> map = new HashMap<String, Object>();
                                    map.put("Nombre", nom);
                                    map.put("Email", us);
                                    map.put("Contraseña", pass);

                                    String id = mAuth.getCurrentUser().getUid();
                                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                dialog.dismiss();
                                                Toast.makeText(getApplicationContext(), R.string.usuario_agr_corr, Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(Main3Activity.this, MainActivity.class));
                                                finish();
                                            }
                                        }
                                    });
                                }
                                else {

                                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                        dialog.dismiss();
                                        Toast.makeText(Main3Activity.this, R.string.corr_exist, Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        dialog.dismiss();
                                        Toast.makeText(Main3Activity.this, R.string.no_reg, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });

                        }
                    }
                }
                break;
        }
    }




}

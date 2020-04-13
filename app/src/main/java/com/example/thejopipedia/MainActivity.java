package com.example.thejopipedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edUser, edPass;
    private Button btnInic,  btnReg;
    private String us, pass;
    private TextView txtJP;
    private ProgressDialog dialog;
    private ImageView imgClass, imgInfo;
    AlertDialog.Builder opdialog;
    private Usuario user;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //VERIFICAR SI HAY ALGUN USUARIO CON LA INICION SESIADA
        user = Preferences.getUserData(this);
        if (!user.getNombre().equalsIgnoreCase(" ")){
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
            finish();
        }

        //FIND VIEW ID
        edUser = findViewById(R.id.edUser);
        btnInic = findViewById(R.id.btnInic);
        edPass = findViewById(R.id.edPass);
        btnReg=findViewById(R.id.btnReg);
        imgClass=findViewById(R.id.imgClass);
        imgInfo=findViewById(R.id.imgInfo);
        txtJP=findViewById(R.id.txtJP);
        //ONCLICKS
        edUser.setOnClickListener(this);
        edPass.setOnClickListener(this);
        btnInic.setOnClickListener(this);
        btnReg.setOnClickListener(this);
        imgClass.setOnClickListener(this);
        imgInfo.setOnClickListener(this);
        txtJP.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnInic:
                dialog.setMessage("Iniciando sesión");
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                us=edUser.getText().toString();
                pass=edPass.getText().toString();

                if (us.isEmpty()||pass.isEmpty())
                {
                    dialog.dismiss();
                    Toast.makeText(this, R.string.llenar_campos, Toast.LENGTH_SHORT).show();
                }
                else {

                    Usuario.IniciarSesion(this, dialog, us, pass);
                }
                break;
            case R.id.btnReg:
                startActivity(new Intent(this, Main3Activity.class));
                finish();
                break;
            case R.id.imgClass:
            case R.id.txtJP:
                Toast.makeText(MainActivity.this, "By: Lewis Matos y Eiron Diaz", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imgInfo:
                opdialog=new AlertDialog.Builder(this);
                    opdialog.setMessage("JopiPedia es un proyecto desarrollado por Lewis Matos, Eiron Díaz y Kerbin Díaz. " + "\n" +
                            "Éste tiene como finalidad determinar la capacidad creativa e implementación de la lógica " +
                            "de cada uno de los developers, a traves de un divertido programa sobre diversos temas sobre el saber.")
                        .setTitle("INFORMACIÓN")
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
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

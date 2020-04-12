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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

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

                    String url = "https://thejopipedia.000webhostapp.com/wsJSONLogin.php?correo=" + us + "&pass=" + pass;

                    url = url.replace(" ", "%20");

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            JSONArray json = response.optJSONArray("usuario");

                            try {
                                for (int i = 0; i < json.length(); i++){
                                    Usuario user = new Usuario();
                                    JSONObject jsonObject = null;
                                    jsonObject = json.getJSONObject(i);

                                    user.setIdusuario(jsonObject.getString("id"));
                                    user.setNombre(jsonObject.getString("nombre"));
                                    user.setCorreo(jsonObject.getString("correo"));
                                    user.setContraseña(jsonObject.getString("contraseña"));

                                    Preferences.SaveUserData(MainActivity.this, user.getIdUsuario(), user.getNombre(), user.getCorreo(), user.getContraseña());
                                }
                                dialog.dismiss();
                                startActivity(new Intent(MainActivity.this, Main2Activity.class));

                            } catch (JSONException e) {
                                e.printStackTrace();
                                dialog.dismiss();
                                Toast.makeText(MainActivity.this, R.string.no_estab_conex, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, R.string.no_inic_sesion, Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });

                    RequestQueue requestQueue = Volley.newRequestQueue(this);
                    requestQueue.add(jsonObjectRequest);
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

package com.example.thejopipedia;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ApuntesActivity extends AppCompatActivity implements View.OnClickListener {

    AlertDialog.Builder opdialog;
    private Window window;
    ImageView btnVolver, btnListo;
    EditText encabezado, contenido;
    private Usuario user;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apuntes);
        dialog = new ProgressDialog(this);
        String colorbarra = "#383E40";

        user = Preferences.getUserData(this);

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
                String enc = encabezado.getText().toString();
                String cont = contenido.getText().toString();

                if (!enc.isEmpty() || !cont.isEmpty()){
                    opdialog = new AlertDialog.Builder(this);
                    opdialog.setMessage(R.string.d_salir_s_guar)
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
                else {
                    startActivity(new Intent(ApuntesActivity.this, CuentaActivity.class));
                    finish();
                }
                break;
            case R.id.btnListo:
                dialog.setMessage("Guardando");
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                final String enc1 = encabezado.getText().toString();
                final String cont1 = contenido.getText().toString();

                if (enc1.isEmpty() || cont1.isEmpty()){
                    Toast.makeText(this, R.string.llenar_campos, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
                else{

                    String url = "https://thejopipedia.000webhostapp.com/wsJSONGuardarNota.php";

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(ApuntesActivity.this, R.string.guardado_correctamente, Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            startActivity(new Intent(ApuntesActivity.this, CuentaActivity.class));
                            finish();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(ApuntesActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String, String> map = new HashMap<String, String>();
                            map.put("encabezado", enc1);
                            map.put("contenido", cont1);
                            map.put("id", user.getIdUsuario());
                            return map;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(this);
                    requestQueue.add(stringRequest);
                }
                break;
        }
    }
}

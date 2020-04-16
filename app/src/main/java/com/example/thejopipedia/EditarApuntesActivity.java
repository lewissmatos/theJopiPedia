package com.example.thejopipedia;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
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

import java.util.HashMap;
import java.util.Map;

public class EditarApuntesActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView btnEliminar, btnVolver, btnListo;
    AlertDialog.Builder opdialog;
    private Window window;
    private String idApunte;
    EditText encabezado, contenido;
    TextView contador;
    private Usuario user;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_apuntes);

        try {
            Bundle b = getIntent().getExtras();
            idApunte = b.getString("id");
        } catch (Exception e){}

        dialog = new ProgressDialog(this);

        String colorbarra = "#2B2B33";

        user = Preferences.getUserData(this);

        this.window = getWindow();
        //barcolor
        window.setStatusBarColor(Color.parseColor(colorbarra));

        encabezado = findViewById(R.id.encabezado);
        contenido= findViewById(R.id.contenido);

        contador= findViewById(R.id.contador);

        contenido.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP){
                    contador.setText(String.valueOf(contenido.length()) + "/400");
                }
                return false;
            }
        });

        btnVolver= findViewById(R.id.btnVolver);
        btnListo= findViewById(R.id.btnListo);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnEliminar.setOnClickListener(this);
        btnVolver.setOnClickListener(this);
        btnListo.setOnClickListener(this);

        getApunte();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnVolver:
                String enc = encabezado.getText().toString();
                String cont = contenido.getText().toString();

                if (!enc.isEmpty() || !cont.isEmpty()){
                    opdialog = new AlertDialog.Builder(this);
                    opdialog.setMessage("Desea salir sin guardar")
                            .setTitle(R.string.advertencia)
                            .setIcon(R.drawable.advertencia)
                            .setPositiveButton(R.string.aceptar_sesion, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    startActivity(new Intent(EditarApuntesActivity.this, CuentaActivity.class));
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
                    startActivity(new Intent(EditarApuntesActivity.this, CuentaActivity.class));
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
                    dialog.dismiss();
                    Toast.makeText(this, "No puedes dejar campos vacíos", Toast.LENGTH_SHORT).show();
                }
                else{
                    editApunte(enc1, cont1);
                }
                break;
            case R.id.btnEliminar:
                opdialog = new AlertDialog.Builder(this);
                opdialog.setMessage("Seguro que desea eliminar")
                        .setTitle(R.string.advertencia)
                        .setIcon(R.drawable.eliminar_rojo)
                        .setPositiveButton(R.string.aceptar_sesion, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                deleteApunte();
                            }
                        }).setNegativeButton(R.string.cancelar_sesion, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                opdialog.create();
                opdialog.show();
        }

    }

    private void getApunte(){
        dialog.setMessage("Cargando apuntes…");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        String url = "https://thejopipedia.000webhostapp.com/wsJSONGetNotaById.php?id=" + idApunte;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONArray json = response.optJSONArray("nota");

                try {
                    for (int i = 0; i < json.length(); i++){
                        JSONObject jsonObject = null;
                        jsonObject = json.getJSONObject(i);

                        encabezado.setText(jsonObject.getString("encabezado"));
                        contenido.setText(jsonObject.getString("contenido"));

                    }
                    dialog.dismiss();

                } catch (JSONException e) {
                    e.printStackTrace();
                    dialog.dismiss();
                    Toast.makeText(EditarApuntesActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EditarApuntesActivity.this, "Error al cargar los apuntes", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }

    private void deleteApunte(){
        dialog.setMessage("Eliminado apunte");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        String url = "https://thejopipedia.000webhostapp.com/wsJSONDeteleNota.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dialog.dismiss();
                Toast.makeText(EditarApuntesActivity.this, "El apunte ha sido eliminado", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditarApuntesActivity.this, CuentaActivity.class));
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                Toast.makeText(EditarApuntesActivity.this, "Ha ocurrido un error al eliminar el apunte", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("id", idApunte);

                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void editApunte(final String encabezado, final String contenido){
        dialog.setMessage("Editando apunte");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        String url = "https://thejopipedia.000webhostapp.com/wsJSONEditNota.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dialog.dismiss();
                Toast.makeText(EditarApuntesActivity.this, "El apunte se ha editado correctamente", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditarApuntesActivity.this, CuentaActivity.class));
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                Toast.makeText(EditarApuntesActivity.this, "Ha ocurrido un error al editar el apunte", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("encabezado", encabezado);
                map.put("contenido", contenido);
                map.put("id", idApunte);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}

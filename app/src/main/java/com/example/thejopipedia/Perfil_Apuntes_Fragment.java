package com.example.thejopipedia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.thejopipedia.RecylclerViewAdapter.RecyclerViewAdapterNota;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Perfil_Apuntes_Fragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewAdapterNota adapter;
    private ImageView añadir_nota;
    private EditText encabezado, contenido;
    private ArrayList<Notas> notas;
    private TextView txtNuevo;
    private ProgressDialog dialog;
    private Usuario user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil__apuntes_, container, false);

        dialog = new ProgressDialog(getContext());

        user = Preferences.getUserData(getContext());

        añadir_nota = view.findViewById(R.id.añadir_nota);

        encabezado = view.findViewById(R.id.encabezado);
        contenido = view.findViewById(R.id.contenido);
        txtNuevo = view.findViewById(R.id.txtNuevo);

        añadir_nota.setOnClickListener(this);
        txtNuevo.setOnClickListener(this);

        notas = new ArrayList<>();

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        getNotas();

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.añadir_nota:
            case R.id.txtNuevo:
                startActivity(new Intent(getContext(), ApuntesActivity.class));
                break;
        }
    }

    private void getNotas(){
        dialog.setMessage("Cargando");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        String url = "https://thejopipedia.000webhostapp.com/wsJSONGetNotas.php?idusuario=" + user.getIdUsuario();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONArray json = response.optJSONArray("nota");

                try {
                    for (int i = 0; i < json.length(); i++){
                        Notas nota = new Notas();
                        JSONObject jsonObject = null;
                        jsonObject = json.getJSONObject(i);

                        nota.setId(jsonObject.getString("id"));
                        nota.setEncabezado(jsonObject.getString("encabezado"));
                        nota.setContenido(jsonObject.getString("contenido"));

                        notas.add(nota);
                    }
                    dialog.dismiss();
                    recyclerView.setAdapter(new RecyclerViewAdapterNota(notas, getContext()));

                } catch (JSONException e) {
                    e.printStackTrace();
                    dialog.dismiss();
                    Toast.makeText(getContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonObjectRequest);
    }
}

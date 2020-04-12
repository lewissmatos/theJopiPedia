package com.example.thejopipedia;

import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.firebase.database.core.Context;

import java.util.HashMap;
import java.util.Map;

public class Usuario {

    private String idUsuario;
    private String nombre;
    private String correo;
    private String contraseña;
    private Context context;

    public Usuario(Context context, String idUsuario, String nombre, String correo, String contraseña) {
        this.context = context;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public Usuario() {
    }

    public void IniciarSesion(String email, String pass){

        String url = "thejopipedia.000webhostapp.com/wsJSONRegistro.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
    }

    public void Registrar(final String nombre, final String email, final String pass, String rpass){
        String url = "thejopipedia.000webhostapp.com/wsJSONRegistro.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("nombre", nombre);
                map.put("correo", email);
                map.put("contraseña", pass);
                return map;
            }
        };
    }

    public void LogOut(){

    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdusuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}

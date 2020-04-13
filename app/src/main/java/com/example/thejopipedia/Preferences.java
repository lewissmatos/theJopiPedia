package com.example.thejopipedia;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    public String idUsuario;
    public String nombre;
    public String correo;
    public String contraseña;

    public static void SaveUserData(Context context, String id, String name, String email, String pass){
        SharedPreferences preferences = context.getSharedPreferences("datos", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("id", id);
        editor.putString("nombre", name);
        editor.putString("correo", email);
        editor.putString("contraseña", pass);

        editor.commit();
    }

    public static Usuario getUserData(Context context){
        Usuario user = new Usuario();

        SharedPreferences preferences = context.getSharedPreferences("datos", Context.MODE_PRIVATE);

        user.setIdusuario(preferences.getString("id", ""));
        user.setNombre(preferences.getString("nombre", ""));
        user.setCorreo(preferences.getString("correo", ""));
        user.setContraseña(preferences.getString("contraseña", ""));

        return user;
    }
}

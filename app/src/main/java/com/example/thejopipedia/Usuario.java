package com.example.thejopipedia;

public class Usuario {

    private int idUsuario;
    private String nombre;
    private String correo;
    private String contraseña;

    public Usuario(int idUsuario, String nombre, String correo, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public Usuario() {
    }

    public void IniciarSesion(String email, String pass){
        
    }

    public void Registrar(String nombre, String email, String pass, String rpass){

    }

    public void LogOut(){

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdusuario(int idUsuario) {
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

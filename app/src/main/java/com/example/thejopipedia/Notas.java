package com.example.thejopipedia;

public class Notas {

    private String encabezado;
    private String contenido;
    private String id;


    public Notas(String encabezado, String contenido, String id) {
        this.encabezado = encabezado;
        this.contenido = contenido;
        this.id= id;
    }

    public Notas() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}

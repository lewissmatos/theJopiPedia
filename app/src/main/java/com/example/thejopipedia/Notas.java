package com.example.thejopipedia;

public class Notas {

    private String encabezado;
    private String contenido;

    public Notas(String encabezado, String contenido) {
        this.encabezado = encabezado;
        this.contenido = contenido;
    }

    public Notas() {

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

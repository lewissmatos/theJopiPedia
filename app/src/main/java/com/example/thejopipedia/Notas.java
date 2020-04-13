package com.example.thejopipedia;

public class Notas {

    private String encabezado;
    private String apunte;

    public Notas(String encabezado, String apunte) {
        this.encabezado = encabezado;
        this.apunte = apunte;
    }

    public Notas() {

    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getApunte() {
        return apunte;
    }

    public void setApunte(String apunte) {
        this.apunte = apunte;
    }
}

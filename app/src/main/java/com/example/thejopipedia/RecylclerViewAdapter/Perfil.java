package com.example.thejopipedia.RecylclerViewAdapter;

public class Perfil {

    private int image;
    private int tittle;
    private int puntuacion;
    private int color;

    public Perfil(int image, int tittle, int puntuacion, int color) {
        this.image = image;
        this.tittle = tittle;
        this.puntuacion = puntuacion;
        this.color = color;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getTittle() {
        return tittle;
    }

    public void setTittle(int tittle) {
        this.tittle = tittle;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int desc) {
        this.puntuacion = desc;
    }
}

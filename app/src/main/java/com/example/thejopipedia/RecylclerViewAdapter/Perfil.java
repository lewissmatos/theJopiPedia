package com.example.thejopipedia.RecylclerViewAdapter;

public class Perfil {

    private int image;
    private int tittle;
    private String puntuacion;
    private int color;

    public Perfil(int image, int tittle, String puntuacion, int color) {
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

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String desc) {
        this.puntuacion = desc;
    }
}

package com.example.thejopipedia.RecylclerViewAdapter;

public class Perfil {

    private int image;
    private int tittle;
    private String puntuacion;
    private int textColor;

    public Perfil(int image, int tittle, String puntuacion, int textColor) {
        this.image = image;
        this.tittle = tittle;
        this.puntuacion = puntuacion;
        this.textColor = textColor;
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

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String desc) {
        this.puntuacion = desc;
    }
}

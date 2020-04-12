package com.example.thejopipedia.RecylclerViewAdapter;

public class Tabla {

    private int image;
    private int tittle;
    private String puntuacion;
    private int colorbar;

    public Tabla(int image, int tittle, String puntuacion, int colorbar) {
        this.image = image;
        this.tittle = tittle;
        this.puntuacion = puntuacion;
        this.colorbar = colorbar;
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

    public int getColorbar() {
        return colorbar;
    }

    public void setColorbar(int colorbar) {
        this.colorbar = colorbar;
    }

    public String getPuntuacion() { return puntuacion; }

    public void setPuntuacion(String desc) {
        this.puntuacion = desc;
    }
}

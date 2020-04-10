package com.example.thejopipedia.RecylclerViewAdapter;

public class Tabla {

    private int image;
    private int tittle;
    private int puntuacion;
    private int colorbar;

    public Tabla(int image, int tittle, int puntuacion, int colorbar) {
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

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int desc) {
        this.puntuacion = desc;
    }
}

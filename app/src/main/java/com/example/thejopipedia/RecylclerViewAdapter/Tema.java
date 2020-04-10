package com.example.thejopipedia.RecylclerViewAdapter;

public class Tema {

    private int image;
    private int tittle;
    private int desc;
    private int color;

    public Tema(int image, int tittle, int desc, int color) {
        this.image = image;
        this.tittle = tittle;
        this.desc = desc;
        this.color = color;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getTittle() { return tittle; }

    public void setTittle(int tittle) {
        this.tittle = tittle;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }
}

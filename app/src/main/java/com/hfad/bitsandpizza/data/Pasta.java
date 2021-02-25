package com.hfad.bitsandpizza.data;

import com.hfad.bitsandpizza.R;

public class Pasta {

    private String name;
    private int img;

    public static final Pasta[] pastas = {
        new Pasta("Spaghetti Bolognaise", R.drawable.spaghetti),
        new Pasta("Lasagna", R.drawable.lasagna)
    };

    public Pasta(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return img;
    }

}

package com.hfad.bitsandpizza.data;

import com.hfad.bitsandpizza.R;

public class Pizza {

    private String name;
    private int img;

    public static final Pizza[] pizzas = {
        new Pizza("Diavolo", R.drawable.diavolo),
        new Pizza("Funghi", R.drawable.funghi)
    };

    private Pizza(String name, int img) {
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

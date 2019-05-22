package com.vladgeorgescu.recipesforhappiness.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Ingredient {

    private String name;

    public Ingredient(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

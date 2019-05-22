package com.vladgeorgescu.recipesforhappiness.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Step {

    private String description;

    public Step(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

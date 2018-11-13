package com.vladgeorgescu.recipesforhappiness.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Ingredient implements Parcelable {

    private final long id;
    private String name;

    public Ingredient(String name, long id){
        this.name = name;
        this.id = id;
    }


    private Ingredient(Parcel in) {
        name = in.readString();
        id = in.readLong();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeLong(id);
    }

    public static final Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel in) {
            return new Ingredient(in);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };
}

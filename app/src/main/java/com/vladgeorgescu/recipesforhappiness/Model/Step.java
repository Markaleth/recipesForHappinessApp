package com.vladgeorgescu.recipesforhappiness.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Step implements Parcelable {

    private final long id;
    private String description;

    public Step(String description, long id){
        this.description = description;
        this.id = id;
    }

    protected Step(Parcel in) {
        id = in.readLong();
        description = in.readString();
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(description);
    }

    public static final Creator<Step> CREATOR = new Creator<Step>() {
        @Override
        public Step createFromParcel(Parcel in) {
            return new Step(in);
        }

        @Override
        public Step[] newArray(int size) {
            return new Step[size];
        }
    };
}

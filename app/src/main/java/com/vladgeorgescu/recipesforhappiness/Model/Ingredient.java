package com.vladgeorgescu.recipesforhappiness.Model;

public class Ingredient {

    private String name;
    private String quantity;

    public Ingredient(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
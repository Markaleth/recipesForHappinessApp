package com.vladgeorgescu.recipesforhappiness.models;

import java.util.ArrayList;

/**
 * Created by vladadoreme on 26/02/2018.
 */

public class Recipe {

    private String recipeName;
    private String recipeUrl;
    private ArrayList<String> recipeIngredients;
    private ArrayList<String> recipeSteps;

    public Recipe() {
        recipeIngredients = new ArrayList<>();
        recipeSteps = new ArrayList<>();
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeUrl() {
        return recipeUrl;
    }

    public void setRecipeUrl(String recipeUrl) {
        this.recipeUrl = recipeUrl;
    }

    public ArrayList<String> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(ArrayList<String> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public ArrayList<String> getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(ArrayList<String> recipeSteps) {
        this.recipeSteps = recipeSteps;
    }
}


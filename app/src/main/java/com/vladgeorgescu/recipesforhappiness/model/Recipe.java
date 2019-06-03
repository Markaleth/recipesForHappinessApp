package com.vladgeorgescu.recipesforhappiness.model;

import java.util.ArrayList;

/**
 * Created by vladadoreme on 26/02/2018.
 */

public class Recipe {

    private String recipeName;
    private String recipeUrl;
    private ArrayList<String> recipeIngredients = new ArrayList<>();
    private ArrayList<String> recipeSteps = new ArrayList<>();

    public Recipe(){
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


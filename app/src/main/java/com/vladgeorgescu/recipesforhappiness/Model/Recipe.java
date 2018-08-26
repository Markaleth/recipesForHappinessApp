package com.vladgeorgescu.recipesforhappiness.Model;

import java.net.URL;

/**
 * Created by vladadoreme on 26/02/2018.
 */

public class Recipe {

    private String recipeName;
    private String recipeUrl;
    private String recipeIngredients;
    private String recipeSteps;


    public Recipe (String name, String url, String ingredients, String steps){
        this.recipeName = name;
        this.recipeUrl = url;
        this.recipeIngredients = ingredients;
        this.recipeSteps = steps;
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

    public String getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(String recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public String getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(String recipeSteps) {
        this.recipeSteps = recipeSteps;
    }
}

package com.vladgeorgescu.recipesforhappiness.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladadoreme on 26/02/2018.
 */

public class Recipe {

    private String recipeName;
    private String recipeUrl;
    private List<String> recipeIngredients;
    private List<String> recipeSteps;

    public Recipe(){

    }

    public Recipe(String name, String url, ArrayList<String> ingredients, ArrayList<String> steps) {
        this.recipeName = name;
        this.recipeUrl = url;
        this.recipeIngredients = ingredients;
        this.recipeSteps = steps;
    }

    private static int lastRecipeId = 0;

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

    public List<String> getRecipeIngredients() {
        return recipeIngredients;
    }

    public List<String> setRecipeIngredients(String ingredient) {
        this.recipeIngredients.add(ingredient);
        return recipeIngredients;
    }

    public List<String> getRecipeSteps() {
        return recipeSteps;
    }

    public List<String> setRecipeSteps(String step) {
        this.recipeSteps.add(step);
        return recipeSteps;

    }
}


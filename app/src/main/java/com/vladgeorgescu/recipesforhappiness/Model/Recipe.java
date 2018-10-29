package com.vladgeorgescu.recipesforhappiness.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladadoreme on 26/02/2018.
 */

public class Recipe {

    private String recipeName;
    private String recipeUrl;
    private ArrayList<Ingredient> recipeIngredients;
    private ArrayList<Step> recipeSteps;

    public Recipe(){

    }

    public Recipe(String name, String url, ArrayList<Ingredient> ingredients, ArrayList<Step> steps) {
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

    public ArrayList<Ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public ArrayList<Ingredient> setRecipeIngredients(Ingredient ingredient) {
        this.recipeIngredients.add(ingredient);
        return recipeIngredients;
    }

    public ArrayList<Step> getRecipeSteps() {
        return recipeSteps;
    }

    public ArrayList<Step> setRecipeSteps(Step step) {
        this.recipeSteps.add(step);
        return recipeSteps;
    }


}


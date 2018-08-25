package com.vladgeorgescu.recipesforhappiness.Model;

import java.net.URL;

/**
 * Created by vladadoreme on 26/02/2018.
 */

public class Recipe {

    public String recipeName;
    public String recipeDescription;
    public String ingredients [];
    public String cookTime;
    public URL recipeUrl;
    public String notes;

    public Recipe (String name, String description){
        recipeName = name;
        recipeDescription = description;
    }


    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public URL getRecipeUrl() {
        return recipeUrl;
    }

    public void setRecipeUrl(URL recipeUrl) {
        this.recipeUrl = recipeUrl;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

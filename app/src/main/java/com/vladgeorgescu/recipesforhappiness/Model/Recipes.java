package com.vladgeorgescu.recipesforhappiness.Model;

import java.util.ArrayList;
import java.util.List;

public class Recipes {

    List<Recipe> recipeList = new ArrayList<Recipe>();

    public void setRecipeList(List<Recipe> recipeList, Recipe recipe) {
        recipeList.add(recipe);
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }


}

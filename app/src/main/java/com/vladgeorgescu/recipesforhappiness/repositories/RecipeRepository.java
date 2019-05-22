package com.vladgeorgescu.recipesforhappiness.repositories;

import com.vladgeorgescu.recipesforhappiness.model.Ingredient;
import com.vladgeorgescu.recipesforhappiness.model.Recipe;
import com.vladgeorgescu.recipesforhappiness.model.Step;

import java.util.List;

public interface RecipeRepository {

    List<Recipe> getRecipes();

    Recipe getRecipe();

    List<Ingredient> getRecipeIngredients();

    List<Step> getRecipeSteps();
}

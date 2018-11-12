package com.vladgeorgescu.recipesforhappiness.Epoxy;

import android.view.View;

import com.airbnb.epoxy.EpoxyAdapter;
import com.vladgeorgescu.recipesforhappiness.Model.Ingredient;
import com.vladgeorgescu.recipesforhappiness.Model.Recipe;
import com.vladgeorgescu.recipesforhappiness.Model.Step;
import com.vladgeorgescu.recipesforhappiness.R;

import java.util.ArrayList;
import java.util.Random;

public class RecipeAdapter extends EpoxyAdapter {

    private Recipe recipe;
    private AdapterCallbacks callbacks;
    AddRecipeLabelEpoxyModel recipeLabel = new AddRecipeLabelEpoxyModel_().labelText(R.string.recipes_screen_label);
    AddRecipeLabelEpoxyModel ingredientLabel = new AddRecipeLabelEpoxyModel_().labelText(R.string.ingredients_label);
    AddRecipeLabelEpoxyModel stepLabel = new AddRecipeLabelEpoxyModel_().labelText(R.string.steps_label);
    AddRecipeFormHeader recipeFormHeader = new AddRecipeFormHeader_();
    AddNewRecipeFormCell ingredientCell = new AddNewRecipeFormCell_().hintText(R.string.recipe_ingredients_text_input_hint);
    AddNewRecipeFormCell stepCell = new AddNewRecipeFormCell_().hintText(R.string.recipe_steps_text_input_hint);
    ArrayList<String> ingredientCellIds = new ArrayList<>();
    ArrayList<String> ids = new ArrayList<>();
    View.OnClickListener addIngredientClickListener;
    String ingredientCellId;
    String elementId;


    public RecipeAdapter(AdapterCallbacks callbacks, Recipe recipe) {
        this.callbacks = callbacks;
        this.recipe = recipe;
        enableDiffing();
    }

    public void setData(Recipe recipe) {
        models.add(recipeLabel);
        models.add(recipeFormHeader);
        models.add(ingredientLabel);
        for (Ingredient ingredient : recipe.getRecipeIngredients()) {
            models.add(new AddNewRecipeFormCell_()
                    .hintText(R.string.recipe_ingredients_text_input_hint)
                    .ingredientFabOnClickListener((model, parentView, clickedView, position) -> {
                        callbacks.onAddIngredient();
                    }));
        }
        models.add(stepLabel);
        for (Step step : recipe.getRecipeSteps()) {
            models.add(new AddNewRecipeFormCell_().hintText(R.string.recipe_steps_text_input_hint));
        }
        notifyModelsChanged();
    }


    public String setIngredientIds() {
        int randomNumber = new Random().nextInt(100000);
        String ingredientIdString = "ingredient" + String.format("%03d", randomNumber);
        ingredientCellIds.add(ingredientIdString);
        return ingredientCellId;
    }

    public String setIds() {
        int randomNumber = new Random().nextInt(100000);
        String id = "id" + String.format("%03d", randomNumber);
        ids.add(id);
        return elementId;
    }


}

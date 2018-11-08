package com.vladgeorgescu.recipesforhappiness.Epoxy;

import android.support.annotation.NonNull;

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.TypedEpoxyController;
import com.vladgeorgescu.recipesforhappiness.Model.Ingredient;
import com.vladgeorgescu.recipesforhappiness.Model.Recipe;
import com.vladgeorgescu.recipesforhappiness.Model.Step;
import com.vladgeorgescu.recipesforhappiness.R;

import static com.airbnb.epoxy.EpoxyAsyncUtil.getAsyncBackgroundHandler;

public class AddNewRecipeController extends TypedEpoxyController<Recipe> {
    @AutoModel
    AddRecipeLabelEpoxyModel_ addRecipeLabel;
    @AutoModel
    AddRecipeLabelEpoxyModel_ ingredientLabel;
    @AutoModel
    AddRecipeLabelEpoxyModel_ stepLabel;
    @AutoModel
    AddRecipeFormHeader_ addRecipeHeaderEpoxyModel;
    @AutoModel
    AddNewRecipeFormCell_ ingredientCell;
    @AutoModel
    AddNewRecipeFormCell_ stepCell;


    private AdapterCallbacks callbacks;

    public AddNewRecipeController(AdapterCallbacks callbacks) {
        super(getAsyncBackgroundHandler(), getAsyncBackgroundHandler());
        this.callbacks = callbacks;
        setDebugLoggingEnabled(true);
    }

    @Override
    protected void buildModels(Recipe recipe) {
        addRecipeLabel.labelText(R.string.recipe_name);
        addRecipeLabel.addTo(this);

        addRecipeHeaderEpoxyModel.addTo(this);

        ingredientLabel.labelText(R.string.ingredients_label);
        ingredientLabel.addTo(this);
        for (Ingredient ingredient : recipe.getRecipeIngredients()) {
            ingredientCell.hintText(R.string.recipe_ingredients_text_input_hint);
            ingredientCell.ingredientFabOnClickListener((model, parentView, clickedView, position) -> {
                callbacks.onAddIngredient();
            });
            ingredientCell.addTo(this);
        }

        stepLabel.labelText(R.string.steps_label);
        stepLabel.addTo(this);
        for (Step step : recipe.getRecipeSteps()) {
            stepCell.hintText(R.string.recipe_steps_text_input_hint);
            stepCell.ingredientFabOnClickListener((model, parentView, clickedView, position) -> {
                callbacks.onAddIngredient();
            });
            stepCell.addTo(this);
        }

    }

    @Override
    protected void onExceptionSwallowed(@NonNull RuntimeException exception) {
        throw exception;
    }
}



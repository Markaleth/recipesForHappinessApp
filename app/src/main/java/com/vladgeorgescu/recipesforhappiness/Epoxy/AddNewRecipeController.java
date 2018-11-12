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
    private Recipe recipe;

    public AddNewRecipeController(AdapterCallbacks callbacks, Recipe recipe) {
        super(getAsyncBackgroundHandler(), getAsyncBackgroundHandler());
        this.callbacks = callbacks;
        this.recipe = recipe;
        setDebugLoggingEnabled(true);
        setData(recipe);

    }

    @Override
    protected void buildModels(Recipe recipe) {
        add(addRecipeLabel.labelText(R.string.recipes_screen_label));
        add(addRecipeHeaderEpoxyModel);
        add(ingredientLabel.labelText(R.string.ingredients_label));
        for (Ingredient ingredient : recipe.getRecipeIngredients()) {
            add(ingredientCell
                    .hintText(R.string.recipe_ingredients_text_input_hint)
                    .ingredientFabOnClickListener((model, parentView, clickedView, position) -> {
                        callbacks.onAddIngredient();
                    }));
        }
        add(stepLabel.labelText(R.string.steps_label));
        for (Step step : recipe.getRecipeSteps()) {
            add(stepCell.hintText(R.string.recipe_steps_text_input_hint));
        }
    }

    @Override
    protected void onExceptionSwallowed(@NonNull RuntimeException exception) {
        throw exception;
    }
}



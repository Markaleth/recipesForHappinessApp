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
    SaveRecipeFabModel_ saveRecipeFab;

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
        for (int i = 0; i < recipe.getRecipeIngredients().size(); i++) {
            Ingredient ingredient = recipe.getRecipeIngredients().get(i);

            add(new AddNewRecipeFormCell_()
                    .id(ingredient.getId(), recipe.getRecipeIngredients().size())
                    .hintText(R.string.recipe_ingredients_text_input_hint)
                    .cellFabOnClickListener((model, parentView, clickedView, position) -> {
                        callbacks.onAddIngredient();
                    }));
        }

        add(stepLabel.labelText(R.string.steps_label));

        for (int i = 0; i < recipe.getRecipeSteps().size(); i++) {
            Step step = recipe.getRecipeSteps().get(i);

            add(new AddNewRecipeFormCell_()
                    .id(step.getId(), recipe.getRecipeIngredients().size())
                    .hintText(R.string.recipe_steps_text_input_hint)
                    .cellFabOnClickListener((model, parentView, clickedView, position) -> {
                        callbacks.onAddStep();
                    }));
        }

        add(saveRecipeFab.saveRecipeClickListener((model, parentView, clickedView, position) -> {
            callbacks.saveRecipe();
        }));

    }


    @Override
    protected void onExceptionSwallowed(@NonNull RuntimeException exception) {
        throw exception;
    }
}



package com.vladgeorgescu.recipesforhappiness.Epoxy;

import com.airbnb.epoxy.EpoxyAdapter;
import com.vladgeorgescu.recipesforhappiness.Model.Ingredient;
import com.vladgeorgescu.recipesforhappiness.Model.Recipe;
import com.vladgeorgescu.recipesforhappiness.Model.Step;
import com.vladgeorgescu.recipesforhappiness.R;

public class RecipeAdapter extends EpoxyAdapter {

    private Recipe recipe;
    private AdapterCallbacks callbacks;
    AddRecipeLabelEpoxyModel recipeLabel = new AddRecipeLabelEpoxyModel_().labelText(R.string.recipes_screen_label);
    AddRecipeLabelEpoxyModel ingredientLabel = new AddRecipeLabelEpoxyModel_().labelText(R.string.ingredients_label);
    AddRecipeLabelEpoxyModel stepLabel = new AddRecipeLabelEpoxyModel_().labelText(R.string.steps_label);
    AddRecipeFormHeader recipeFormHeader = new AddRecipeFormHeader_();
    SaveRecipeFabModel recipeFabModel = new SaveRecipeFabModel_();


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
                    .cellFabOnClickListener((model, parentView, clickedView, position) -> {
                        callbacks.onAddIngredient();
                    }));
        }
        models.add(stepLabel);
        for (Step step : recipe.getRecipeSteps()) {
            models.add(new AddNewRecipeFormCell_().hintText(R.string.recipe_steps_text_input_hint));
        }
        notifyModelsChanged();

        models.add(new SaveRecipeFabModel_().saveRecipeClickListener(((model, parentView, clickedView, position) -> {
            callbacks.saveRecipe();
        })));
    }
}

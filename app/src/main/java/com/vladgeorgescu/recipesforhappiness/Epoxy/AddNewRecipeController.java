package com.vladgeorgescu.recipesforhappiness.Epoxy;

import android.support.annotation.NonNull;

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.TypedEpoxyController;
import com.vladgeorgescu.recipesforhappiness.Model.Ingredient;
import com.vladgeorgescu.recipesforhappiness.Model.Recipe;
import com.vladgeorgescu.recipesforhappiness.Model.Step;
import com.vladgeorgescu.recipesforhappiness.R;

import java.util.ArrayList;
import java.util.List;

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
                    })
            );
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

    public boolean isIngredient() {
        boolean isIngredient = false;
        AddNewRecipeFormCell ingredient;
        AddNewRecipeFormCell cell = null;
        AddNewRecipeFormCell step;
        for (int i = 0; i < getAdapter().getItemCount(); i++) {
            if (getAdapter().getModelAtPosition(i).getLayout() == R.layout.add_recipe_form_cell) {
                cell = (AddNewRecipeFormCell) getAdapter().getModelAtPosition(i);
                if (cell.getHintText() == R.string.recipe_ingredients_text_input_hint) {
                    isIngredient = true;
                } else if (cell.getHintText() == R.string.recipe_steps_text_input_hint) {
                    isIngredient = false;
                }
            }
        }
        return isIngredient;
    }

    public List<Ingredient> getIngredients() {
        AddNewRecipeFormCell cell;
        List<Ingredient> ingredients = new ArrayList<>();
        for (int i = 0; i < getAdapter().getItemCount(); i++) {
            if (isIngredient()) {
                cell = (AddNewRecipeFormCell) getAdapter().getModelAtPosition(i);
                ingredients.add(new Ingredient(cell.getCellText(), recipe.getRecipeIngredients().size()));
            }
        }
        return ingredients;
    }

    public List<Step> getSteps() {
        AddNewRecipeFormCell cell;
        List<Step> steps = new ArrayList<>();
        for (int i = 0; i < getAdapter().getItemCount(); i++) {
            if (!isIngredient()) {
                cell = (AddNewRecipeFormCell) getAdapter().getModelAtPosition(i);
                steps.add(new Step(cell.getCellText(), recipe.getRecipeSteps().size()));
            }
        }
        return steps;
    }

    public String getRecipeNameText() {
        return addRecipeHeaderEpoxyModel.getRecipeURL();
    }

    public String getRecipeUrlText(){
        return addRecipeHeaderEpoxyModel.getRecipeURL();
    }

}



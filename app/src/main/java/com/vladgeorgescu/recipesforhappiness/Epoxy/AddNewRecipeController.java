package com.vladgeorgescu.recipesforhappiness.Epoxy;

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.EpoxyController;

public class AddNewRecipeController extends EpoxyController {
    @AutoModel
    AddRecipeLabelEpoxyModel_ addRecipeHeaderLabelEpoxyModel;
    @AutoModel
    AddRecipeHeaderEpoxyModel_ addRecipeHeaderEpoxyModel;
    @AutoModel
    IngredientEpoxyModel_ ingredientEpoxyModel;

    @Override
    protected void buildModels() {
        addRecipeHeaderLabelEpoxyModel.setLabelText("Recipe name");
        addRecipeHeaderLabelEpoxyModel.addTo(this);
        addRecipeHeaderEpoxyModel.addTo(this);
        ingredientEpoxyModel.addTo(this);

    }

}

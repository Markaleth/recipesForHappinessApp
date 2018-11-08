package com.vladgeorgescu.recipesforhappiness.Adapters.Ingredient;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

public class IngredientHolder extends RecyclerView.ViewHolder {

    private CardView ingredientCard;
    private EditText ingredientName;
    private FloatingActionButton addAdditionalIngredient;

    public IngredientHolder(@NonNull View itemView) {
        super(itemView);
//        ingredientCard = itemView.findViewById(R.id.addIngredientCardView);
//        ingredientName = itemView.findViewById(R.id.ingredientName);
//        addAdditionalIngredient = itemView.findViewById(R.id.addIngredientFab);

    }

    public void setIngredientCard(CardView ingredientCard) {
        this.ingredientCard = ingredientCard;
    }

    public void setIngredientName(EditText ingredientName) {
        this.ingredientName = ingredientName;
    }

    public void setAddAdditionalIngredient(FloatingActionButton addAdditionalIngredient) {
        this.addAdditionalIngredient = addAdditionalIngredient;
    }

    public CardView getIngredientCard() {

        return ingredientCard;
    }

    public EditText getIngredientName() {
        return ingredientName;
    }

    public FloatingActionButton getAddAdditionalIngredient() {
        return addAdditionalIngredient;
    }
}

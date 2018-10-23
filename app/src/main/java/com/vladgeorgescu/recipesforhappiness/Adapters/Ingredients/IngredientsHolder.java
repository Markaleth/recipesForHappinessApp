package com.vladgeorgescu.recipesforhappiness.Adapters.Ingredients;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.vladgeorgescu.recipesforhappiness.R;

public class IngredientsHolder extends RecyclerView.ViewHolder {
    private TextView ingredientName;
    private ImageButton addMoreIngredients;

    public IngredientsHolder(View itemView) {
        super(itemView);
        ingredientName = itemView.findViewById(R.id.ingredientName);
        addMoreIngredients = itemView.findViewById(R.id.addIngredientFab);
    }

    public TextView getIngredientName() {
        return ingredientName;
    }

    public ImageButton getAddMoreIngredients() {
        return addMoreIngredients;
    }


}

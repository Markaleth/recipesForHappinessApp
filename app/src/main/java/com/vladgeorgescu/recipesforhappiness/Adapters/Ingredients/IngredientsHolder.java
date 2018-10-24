package com.vladgeorgescu.recipesforhappiness.Adapters.Ingredients;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.vladgeorgescu.recipesforhappiness.R;

import butterknife.BindView;

public class IngredientsHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.addIngredientCardView)
    CardView addIngredientCard;
    @BindView(R.id.ingredientName)
    EditText ingredientNameTextField;
    @BindView(R.id.addIngredientFab)
    FloatingActionButton addMoreIngredients;

    IngredientsHolder(View itemView) {
        super(itemView);
    }

    CardView getAddIngredientCard() {
        return addIngredientCard;
    }

    public EditText getIngredientName() {
        return ingredientNameTextField;
    }

    public ImageButton getAddMoreIngredients() {
        return addMoreIngredients;
    }


}

package com.vladgeorgescu.recipesforhappiness.Adapters.Ingredients;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.vladgeorgescu.recipesforhappiness.Model.Ingredient;
import com.vladgeorgescu.recipesforhappiness.Model.Recipe;
import com.vladgeorgescu.recipesforhappiness.R;

import java.util.List;

public class IngredientsViewAdapter extends RecyclerView.Adapter<IngredientsHolder> {


    private List<Ingredient> ingredients;
    private Ingredient ingredient;
    Context context;

    public IngredientsViewAdapter(Context context, List<Ingredient> ingredients){
        this.context = context;
        this.ingredients = ingredients;
    }


    @NonNull
    @Override
    public IngredientsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ingredient = new Ingredient();
        ingredients.add(ingredient);
        CardView addNewRecipe = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient_row, parent, false);

        return new IngredientsHolder(addNewRecipe);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsHolder holder, int position) {
        Ingredient ingredient = ingredients.get(position);
//        Populate cards with whatever element you want from the model
        holder.addIngredientCard.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        int count = 0;

        try {
            if (ingredients.size() == 0) {
                count = 0;
            } else {
                count = ingredients.size();
            }
        } catch (Exception e) {
        }
        return count;
    }

}

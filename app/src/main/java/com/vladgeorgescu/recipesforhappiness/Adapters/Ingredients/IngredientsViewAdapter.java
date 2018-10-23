package com.vladgeorgescu.recipesforhappiness.Adapters.Ingredients;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vladgeorgescu.recipesforhappiness.Model.Recipe;
import com.vladgeorgescu.recipesforhappiness.R;

import java.util.List;

public class IngredientsViewAdapter extends RecyclerView.Adapter<IngredientsHolder> {


    private Context ingredientsRecyclerViewContext;
    private List<String> ingredients;
    private List<Recipe> recipes;
    private Recipe recipe;


    public IngredientsViewAdapter(Context context, List<String> ingredientList) {
        this.ingredientsRecyclerViewContext = context;
        this.ingredients = ingredientList;
    }

    @NonNull
    @Override
    public IngredientsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View addNewRecipe = LayoutInflater.from(ingredientsRecyclerViewContext).inflate(R.layout.ingredient_tab_fragment, parent, false);

        return new IngredientsHolder(addNewRecipe);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsHolder holder, int position) {
        String ingredient = ingredients.get(position);
        //Populate cards with whatever element you want from the model
        holder.getIngredientName().setText(ingredient);

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

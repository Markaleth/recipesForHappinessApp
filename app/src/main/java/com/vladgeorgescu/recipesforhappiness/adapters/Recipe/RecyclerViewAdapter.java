package com.vladgeorgescu.recipesforhappiness.adapters.Recipe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vladgeorgescu.recipesforhappiness.model.Recipe;
import com.vladgeorgescu.recipesforhappiness.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladadoreme on 26/02/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecipeHolder> {

    private List<Recipe> recipes;
    private Context recyclerViewContext;

    public RecyclerViewAdapter(Context context, List<Recipe> recipes) {
        this.recyclerViewContext = context;
        this.recipes = recipes;

    }

    @NonNull
    @Override
    public RecipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myCreationsView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipies_row, parent, false);
        return new RecipeHolder(myCreationsView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeHolder holder, int position) {
        Recipe recipe = recipes.get(position);
        //Populate cards with whatever element you want from the model
        holder.getRecipeName().setText(recipe.getRecipeName());
    }

    @Override
    public int getItemCount() {
        int count = 0;

        try {
            if (recipes.size() == 0){
                count = 0;
            }
            else {
                count = recipes.size();
            }
        } catch (Exception ignored){}
        return count;
    }

    public void updateItemList(final List<Recipe> itemList){
        this.recipes = itemList;
        notifyDataSetChanged();
    }

}

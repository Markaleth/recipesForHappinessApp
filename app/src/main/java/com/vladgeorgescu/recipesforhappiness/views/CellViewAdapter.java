package com.vladgeorgescu.recipesforhappiness.views;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.ViewGroup;

import com.vladgeorgescu.recipesforhappiness.R;
import com.vladgeorgescu.recipesforhappiness.models.Recipe;

import java.util.ArrayList;
import java.util.List;

public class CellViewAdapter extends RecyclerView.Adapter<CellViewAdapter.ViewHolder> {

    public List<String> steps = new ArrayList<>();
    public List<String> ingredients = new ArrayList<>();
    public List<String> items;

    public static final int VIEW_TYPE_STEP = 0;
    public static final int VIEW_TYPE_INGREDIENT = 1;
    Recipe recipe;

    private CellView cellView;

    public CellViewAdapter() {
        recipe = new Recipe();
        items = new ArrayList<>();
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        cellView = new CellView(parent.getContext());
        switch (viewType) {
            case VIEW_TYPE_STEP:
                cellView.getCellNameTextView().setHint(R.string.recipe_steps_text_input_hint);
                return new ViewHolder(cellView);
            case VIEW_TYPE_INGREDIENT:
                cellView.getCellNameTextView().setHint(R.string.recipe_ingredients_text_input_hint);
                return new ViewHolder(cellView);
            default:
                return new ViewHolder(cellView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Recipe recipe = new Recipe();
        recipe.setRecipeSteps((ArrayList<String>) steps);
        recipe.setRecipeIngredients((ArrayList<String>) ingredients);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



public static class ViewHolder extends RecyclerView.ViewHolder {


    public View view;

    public ViewHolder(View view) {
        super(view);
        this.view = view;
    }
}
}

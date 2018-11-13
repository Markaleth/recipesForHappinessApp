package com.vladgeorgescu.recipesforhappiness.Adapters.Ingredient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vladgeorgescu.recipesforhappiness.Model.Ingredient;
import com.vladgeorgescu.recipesforhappiness.R;

import java.util.ArrayList;

public class IngredientViewAdapter extends RecyclerView.Adapter<IngredientHolder> {
    private ArrayList<Ingredient> ingredientArrayList;
    private Context context;

    public IngredientViewAdapter(ArrayList<Ingredient> ingredientArrayList, Context context) {
        this.ingredientArrayList = ingredientArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public IngredientHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d("IngredientViewAdapter", ".onCreateViewHolder: called");
        View addIngredientView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_recipe_form_cell, viewGroup, false);
        IngredientHolder ingredientHolder = new IngredientHolder(addIngredientView);
        return ingredientHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientHolder ingredientHolder, int i) {

        Log.d("IngredientViewAdapter", ".onBindViewOrder: called");
        ingredientHolder.getAddAdditionalIngredient().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Add another ingredient!", Toast.LENGTH_SHORT).show();
                Log.d("IngredientViewAdapter", "onClick: event");
//                ingredientArrayList.add(new Ingredient(""));
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return ingredientArrayList.size();
    }

    public ArrayList<Ingredient> getIngredientArrayList() {
        return ingredientArrayList;
    }
}

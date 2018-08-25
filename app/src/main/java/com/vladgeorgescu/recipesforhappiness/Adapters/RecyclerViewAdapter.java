package com.vladgeorgescu.recipesforhappiness.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vladgeorgescu.recipesforhappiness.R;

/**
 * Created by vladadoreme on 26/02/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecycleViewHolder> {

    String recipeNameData[];
    Context recyclerViewContext;

    public RecyclerViewAdapter(Context context, String recipeNames[]) {
        recyclerViewContext = context;
        recipeNameData = recipeNames;
    }

    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater myInflater = LayoutInflater.from(recyclerViewContext);
        View myCreationsView = myInflater.inflate(R.layout.recipies_row, parent, false);

        return new RecycleViewHolder(myCreationsView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {
        holder.getRecipeName().setText(recipeNameData[position]);
        holder.recipeImageButton.setImageResource(R.drawable.landing_screen_img);

    }

    @Override
    public int getItemCount() {
        return recipeNameData.length;
    }
}

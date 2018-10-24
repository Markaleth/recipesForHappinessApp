package com.vladgeorgescu.recipesforhappiness.Adapters.Steps;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vladgeorgescu.recipesforhappiness.R;

import java.util.List;

public class StepsViewAdapter extends RecyclerView.Adapter<StepsHolder> {


    private Context stepsRecyclerViewContext;
    private List<String> recipeSteps;


    public StepsViewAdapter(Context context, List<String> recipeStepsList) {
        this.stepsRecyclerViewContext = context;
        this.recipeSteps = recipeStepsList;
    }

    @NonNull
    @Override
    public StepsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View addNewRecipe = LayoutInflater.from(stepsRecyclerViewContext).inflate(R.layout.step_row, parent, false);

        return new StepsHolder(addNewRecipe);
    }

    @Override
    public void onBindViewHolder(@NonNull StepsHolder holder, int position) {
        String step = recipeSteps.get(position);
        //Populate cards with whatever element you want from the model
        holder.getStepName().setText(step);

    }

    @Override
    public int getItemCount() {
        int count = 0;

        try {
            if (recipeSteps.size() == 0) {
                count = 0;
            } else {
                count = recipeSteps.size();
            }
        } catch (Exception e) {
        }
        return count;
    }
}

package com.vladgeorgescu.recipesforhappiness.Adapters.Steps;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.vladgeorgescu.recipesforhappiness.R;

public class StepsHolder extends RecyclerView.ViewHolder {
    private TextView stepName;
    private ImageButton addMoreSteps;

    public StepsHolder(View itemView) {
        super(itemView);
        stepName = itemView.findViewById(R.id.ingredientName);
        addMoreSteps = itemView.findViewById(R.id.addIngredientFab);
    }

    public TextView getStepName() {
        return stepName;
    }

    public ImageButton getAddMoreSteps() {
        return addMoreSteps;
    }


}

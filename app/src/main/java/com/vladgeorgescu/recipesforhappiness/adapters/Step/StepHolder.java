package com.vladgeorgescu.recipesforhappiness.adapters.Step;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

public class StepHolder extends RecyclerView.ViewHolder {

    private CardView stepCard;
    private EditText stepName;
    private FloatingActionButton addAdditionalStep;

    public StepHolder(@NonNull View itemView) {
        super(itemView);
//        stepCard = itemView.findViewById(R.id.addStepCardView);
//        stepName = itemView.findViewById(R.id.ingredientName);
//        addAdditionalStep = itemView.findViewById(R.id.addStepFab);

    }

    public void setStepCard(CardView ingredientCard) {
        this.stepCard = ingredientCard;
    }

    public void setStepName(EditText ingredientName) {
        this.stepName = ingredientName;
    }

    public void setAddAdditionalStep(FloatingActionButton addAdditionalIngredient) {
        this.addAdditionalStep = addAdditionalIngredient;
    }

    public CardView getStepCard() {
        return stepCard;
    }

    public EditText getStepName() {
        return stepName;
    }

    public FloatingActionButton getAddAdditionalStep() {
        return addAdditionalStep;
    }
}


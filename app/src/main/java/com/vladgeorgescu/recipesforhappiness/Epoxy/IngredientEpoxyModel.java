package com.vladgeorgescu.recipesforhappiness.Epoxy;


import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;

import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.vladgeorgescu.recipesforhappiness.R;

import butterknife.BindView;

@EpoxyModelClass(layout = R.layout.ingredient_row)
public class IngredientEpoxyModel extends EpoxyModelWithHolder<IngredientEpoxyModel.IngredientHolder> {

    View.OnClickListener ingredientFabOnClickListener;

    public void setIngredientFabOnClickListener(View.OnClickListener ingredientFabOnClickListener) {
        this.ingredientFabOnClickListener = ingredientFabOnClickListener;
    }

    @Override
    protected IngredientHolder createNewHolder() {
        return new IngredientHolder();
    }

    @Override
    public void bind(@NonNull final IngredientHolder holder) {
        super.bind(holder);
        holder.ingredientName.setText(null);
        holder.addIngredientFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.ingredient_row;
    }

    class IngredientHolder extends BaseEpoxyHolder {
        @BindView(R.id.ingredientName)
        EditText ingredientName;
        @BindView(R.id.addIngredientFab)
        FloatingActionButton addIngredientFab;
        @BindView(R.id.addIngredientCardView)
        CardView ingredientCardView;
        @BindView(R.id.ingredients_constraintLayout)
        ConstraintLayout ingredientConstraintLayout;
    }
}

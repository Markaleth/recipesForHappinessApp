package com.vladgeorgescu.recipesforhappiness.Epoxy;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.widget.EditText;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.vladgeorgescu.recipesforhappiness.R;

import butterknife.BindView;

@EpoxyModelClass(layout = R.layout.add_new_recipe_header)
public class AddRecipeFormHeader extends EpoxyModelWithHolder<AddRecipeFormHeader.AddRecipeFormHeaderHolder> {

    @EpoxyAttribute String recipeName;
    @EpoxyAttribute String recipeURL;


    @Override
    protected AddRecipeFormHeaderHolder createNewHolder() {
        return new AddRecipeFormHeaderHolder();
    }

    @Override
    public void bind(@NonNull AddRecipeFormHeaderHolder holder) {
        super.bind(holder);
        holder.recipeName.setText(null);
        holder.recipeUrl.setText(null);
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.add_new_recipe_header;
    }


    class AddRecipeFormHeaderHolder extends BaseEpoxyHolder {
        @BindView(R.id.recipe_name_editText)
        EditText recipeName;
        @BindView(R.id.recipe_url_editText)
        EditText recipeUrl;
        @BindView(R.id.recipeHeaderConstraintLayout)
        ConstraintLayout recipeHeaderConstraintLayout;
        @BindView(R.id.addRecipeHeader)
        CardView addRecipeHeader;
    }
}


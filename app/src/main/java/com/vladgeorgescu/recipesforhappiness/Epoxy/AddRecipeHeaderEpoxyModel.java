package com.vladgeorgescu.recipesforhappiness.Epoxy;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.widget.EditText;

import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.vladgeorgescu.recipesforhappiness.R;

import butterknife.BindView;

@EpoxyModelClass(layout = R.layout.add_new_recipe_header)
public class AddRecipeHeaderEpoxyModel extends EpoxyModelWithHolder<AddRecipeHeaderEpoxyModel.AddRecipeHeaderHolder> {

    String recipeName;
    String recipeUrl;
    boolean textPresent;
    private int spanSize;

    @Override
    protected AddRecipeHeaderHolder createNewHolder() {
        return new AddRecipeHeaderHolder();
    }

    @Override
    public void bind(@NonNull AddRecipeHeaderHolder holder) {
        super.bind(holder);
        holder.recipeName.setText(null);
        holder.recipeUrl.setText(null);
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return spanSize;
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.add_new_recipe_header;
    }


    class AddRecipeHeaderHolder extends BaseEpoxyHolder {
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


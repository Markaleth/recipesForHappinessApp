package com.vladgeorgescu.recipesforhappiness.Epoxy;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.widget.EditText;

import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.vladgeorgescu.recipesforhappiness.R;

import butterknife.BindView;

@EpoxyModelClass(layout = R.layout.add_new_recipe_header)
public class AddRecipeFormHeader extends EpoxyModelWithHolder<AddRecipeFormHeader.AddRecipeFormHeaderHolder> {

    private AddRecipeFormHeaderHolder viewHolder;


    @Override
    protected AddRecipeFormHeaderHolder createNewHolder() {
        return new AddRecipeFormHeaderHolder();
    }

    @Override
    public void bind(@NonNull AddRecipeFormHeaderHolder holder) {
        super.bind(holder);
        holder.recipeName.setText("ceva");
        viewHolder = holder;
    }

    @Override
    public void unbind(@NonNull AddRecipeFormHeaderHolder holder) {
        super.unbind(holder);
        viewHolder=null;
        Log.e("ceva", "EROARE!!!");
    }

    public String getRecipeName() {
        return viewHolder.recipeName.getText().toString();
    }

    public String getRecipeURL() {
        return  viewHolder.recipeUrl.getText().toString();
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


package com.vladgeorgescu.recipesforhappiness.views;

import android.content.Context;
import androidx.cardview.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.vladgeorgescu.recipesforhappiness.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewRecipeHeaderView extends CardView {


    @BindView(R.id.recipe_name_editText)
    TextView recipeNameTextView;

    @BindView(R.id.recipe_url_editText)
    TextView recipeUrlTextView;

    private String recipeName;
    private String recipeUrl;

    public NewRecipeHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_new_recipe_header, this);
        ButterKnife.bind(this);
    }

    public String getRecipeName() {
        return recipeName = recipeNameTextView.getText().toString();
    }

    public String getRecipeUrl() {
        return recipeUrl = recipeUrlTextView.getText().toString();
    }

}

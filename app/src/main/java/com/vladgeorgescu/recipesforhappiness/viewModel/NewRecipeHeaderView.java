package com.vladgeorgescu.recipesforhappiness.viewModel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vladgeorgescu.recipesforhappiness.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewRecipeHeaderView extends RelativeLayout {

    @BindView(R.id.recipeHeader)
    RelativeLayout recipeHeaderHolder;

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

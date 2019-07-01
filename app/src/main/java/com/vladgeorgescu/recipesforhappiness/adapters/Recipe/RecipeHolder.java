package com.vladgeorgescu.recipesforhappiness.adapters.Recipe;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vladgeorgescu.recipesforhappiness.R;

/**
 * Created by vladadoreme on 26/02/2018.
 */

public class RecipeHolder extends RecyclerView.ViewHolder {

    private TextView recipeName;
    private ImageView recipeImage;


    public TextView getRecipeName() {
        return recipeName;
    }

    public ImageView getRecipeImageButton() {
        return recipeImage;
    }

    RecipeHolder(View itemView) {
        super(itemView);
        recipeName = itemView.findViewById(R.id.recipeName);
        recipeImage = itemView.findViewById(R.id.recipeImg);
    }


}


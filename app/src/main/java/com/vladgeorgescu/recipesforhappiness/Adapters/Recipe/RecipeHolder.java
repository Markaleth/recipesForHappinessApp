package com.vladgeorgescu.recipesforhappiness.Adapters.Recipe;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.vladgeorgescu.recipesforhappiness.Model.Recipe;
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


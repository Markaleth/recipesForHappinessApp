package com.vladgeorgescu.recipesforhappiness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddNewRecipe extends AppCompatActivity {

    private String recipeName;
    private String recipeDescription;
    private String recipeIngredients;
    private String recipeSteps;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_recipe);
    }
}

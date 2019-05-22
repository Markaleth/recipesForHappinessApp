package com.vladgeorgescu.recipesforhappiness;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.vladgeorgescu.recipesforhappiness.FirebaseUtils.FirebaseHandler;
import com.vladgeorgescu.recipesforhappiness.Model.Ingredient;
import com.vladgeorgescu.recipesforhappiness.Model.Recipe;
import com.vladgeorgescu.recipesforhappiness.Model.Step;

import butterknife.ButterKnife;

public class AddNewRecipeActivity extends AppCompatActivity {

    private Recipe recipe = new Recipe();

    private FirebaseHandler firebaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_add_new_recipe);

        final Toolbar addNewRecipeToolbar = findViewById(R.id.add_recipe_toolbar);
        setSupportActionBar(addNewRecipeToolbar);
        getSupportActionBar().setTitle("Add New Recipe");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ButterKnife.bind(this);
        firebaseHandler = new FirebaseHandler();

        initiateToolbar();
        ingredientsAndStepsInit();
//        addRecipeRecyclerView.setAdapter(recipeAdapter);

        //Initialize Firebase objects
        firebaseHandler.getFirebaseDatabase().getReference().child("recipe");
    }

    private void initiateToolbar() {
    }

    public void ingredientsAndStepsInit() {
        this.recipe = new Recipe();
        this.recipe.setRecipeIngredients(new Ingredient(null, recipe.getRecipeIngredients().size()));
        this.recipe.setRecipeSteps(new Step(null, recipe.getRecipeSteps().size()));
    }
}

package com.vladgeorgescu.recipesforhappiness;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.vladgeorgescu.recipesforhappiness.apiUtils.ApiServiceImplementation;
import com.vladgeorgescu.recipesforhappiness.apiUtils.ApiServiceInterface;
import com.vladgeorgescu.recipesforhappiness.model.Recipe;

import butterknife.ButterKnife;

public class AddNewRecipeActivity extends AppCompatActivity {

    private Recipe recipe = new Recipe();

    private ApiServiceInterface apiService = new ApiServiceImplementation();

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

        initiateToolbar();
        ingredientsAndStepsInit();
//        addRecipeRecyclerView.setAdapter(recipeAdapter);

        //Initialize Firebase objects
    }

    private void initiateToolbar() {
    }

    public void ingredientsAndStepsInit() {
    }
}

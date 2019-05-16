package com.vladgeorgescu.recipesforhappiness;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.airbnb.epoxy.EpoxyRecyclerView;
import com.vladgeorgescu.recipesforhappiness.Epoxy.AdapterCallbacks;
import com.vladgeorgescu.recipesforhappiness.Epoxy.AddNewRecipeController;
import com.vladgeorgescu.recipesforhappiness.FirebaseUtils.FirebaseHandler;
import com.vladgeorgescu.recipesforhappiness.Model.Ingredient;
import com.vladgeorgescu.recipesforhappiness.Model.Recipe;
import com.vladgeorgescu.recipesforhappiness.Model.Step;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddNewRecipeActivity extends AppCompatActivity implements AdapterCallbacks {


    @BindView(R.id.add_recipe_toolbar)
    Toolbar addRecipeToolbar;
    @BindView(R.id.add_new_recipe_recyclerView)
    EpoxyRecyclerView addRecipeRecyclerView;

    private Recipe recipe = new Recipe();
    private AddNewRecipeController addNewRecipeController = new AddNewRecipeController(this, recipe);

    private FirebaseHandler firebaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_recipe);

        ButterKnife.bind(this);
        firebaseHandler = new FirebaseHandler();

        initiateToolbar();
        ingredientsAndStepsInit();
        updateController();

        addRecipeRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        addRecipeRecyclerView.setAdapter(addNewRecipeController.getAdapter());
        addRecipeRecyclerView.setController(addNewRecipeController);
//        addRecipeRecyclerView.setAdapter(recipeAdapter);

        //Initialize Firebase objects
        firebaseHandler.getFirebaseDatabase().getReference().child("recipe");
    }

    private void initiateToolbar() {
        addRecipeToolbar = (Toolbar) findViewById(R.id.add_recipe_toolbar);
        if (getSupportActionBar() == null) {
            setSupportActionBar(addRecipeToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onAddIngredient() {
        recipe.setRecipeIngredients(new Ingredient(null, recipe.getRecipeIngredients().size()));
        updateController();
        Toast.makeText(this, "Add new ingredient button clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAddStep() {
        recipe.setRecipeSteps(new Step(null, recipe.getRecipeIngredients().size()));
        updateController();
        Toast.makeText(this, "Add new step button clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void saveRecipe() {
        recipe.setRecipeName(addNewRecipeController.getRecipeNameText());
        recipe.setRecipeUrl(addNewRecipeController.getRecipeUrlText());
        for (Ingredient ingredient : addNewRecipeController.getIngredients()){
            recipe.setRecipeIngredients(ingredient);
        }
        for (Step step : addNewRecipeController.getSteps()){
            recipe.setRecipeSteps(step);
        }

        firebaseHandler.getFirebaseReference().push().setValue(recipe);
        Toast.makeText(this, "Recipe saved!", Toast.LENGTH_SHORT).show();
    }


    public void updateController() {
        addNewRecipeController.setData(recipe);
    }

    public void ingredientsAndStepsInit() {
        this.recipe = new Recipe();
        this.recipe.setRecipeIngredients(new Ingredient(null, recipe.getRecipeIngredients().size()));
        this.recipe.setRecipeSteps(new Step(null, recipe.getRecipeSteps().size()));
    }
}

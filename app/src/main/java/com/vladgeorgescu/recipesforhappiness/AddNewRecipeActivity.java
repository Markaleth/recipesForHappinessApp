package com.vladgeorgescu.recipesforhappiness;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.airbnb.epoxy.EpoxyRecyclerView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.internal.FirebaseAppHelper;
import com.vladgeorgescu.recipesforhappiness.Epoxy.AdapterCallbacks;
import com.vladgeorgescu.recipesforhappiness.Epoxy.AddNewRecipeController;
import com.vladgeorgescu.recipesforhappiness.Epoxy.RecipeAdapter;
import com.vladgeorgescu.recipesforhappiness.Model.Ingredient;
import com.vladgeorgescu.recipesforhappiness.Model.Recipe;
import com.vladgeorgescu.recipesforhappiness.Model.Step;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddNewRecipeActivity extends AppCompatActivity implements AdapterCallbacks {


    @BindView(R.id.add_recipe_toolbar)
    Toolbar addRecipeToolbar;
    @BindView(R.id.add_new_recipe_recyclerView)
    EpoxyRecyclerView addRecipeRecyclerView;

    private Recipe recipe = new Recipe();
    private RecipeAdapter recipeAdapter = new RecipeAdapter(this, recipe);
    private AddNewRecipeController addNewRecipeController;
    private ArrayList<Ingredient> recipeIngredients = new ArrayList<>();
    private ArrayList<Step> recipeSteps = new ArrayList<>();


    private FirebaseDatabase database;
    private DatabaseReference mFirebaseReference;
    private ChildEventListener mChildEventListener;
    private FirebaseAppHelper firebaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_recipe);

        ButterKnife.bind(this);

        initiateToolbar();
        ingredientsAndStepsInit();
        addNewRecipeController = new AddNewRecipeController(this, recipe);
//        recipeAdapter.setData(recipe);
        addNewRecipeController.setData(recipe);

        addRecipeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        addRecipeRecyclerView.setController(addNewRecipeController);
//        addRecipeRecyclerView.setAdapter(recipeAdapter);

        //Initialize Firebase objects
        database = FirebaseDatabase.getInstance();
        mFirebaseReference = database.getReference().child("recipe");
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
        recipe.setRecipeIngredients(new Ingredient(null));
        updateController();
//        addNewRecipeController.requestModelBuild();
        Toast.makeText(this, "Add new ingredient button clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAddStep() {
        this.recipeSteps.add(new Step(null));
        updateController();
        Toast.makeText(this, "Add new step button clicked!", Toast.LENGTH_SHORT).show();
    }

    public void updateController() {
        RecipeAdapter newRecipeAdapter = new RecipeAdapter(this, recipe);
        newRecipeAdapter.setData(this.recipe);
        addRecipeRecyclerView.setAdapter(newRecipeAdapter);


    }

    public void ingredientsAndStepsInit() {
        this.recipe = new Recipe();
        this.recipe.setRecipeIngredients(new Ingredient(null));
        this.recipe.setRecipeSteps(new Step(null));
    }
}

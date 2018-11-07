package com.vladgeorgescu.recipesforhappiness;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import com.airbnb.epoxy.EpoxyRecyclerView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.internal.FirebaseAppHelper;
import com.vladgeorgescu.recipesforhappiness.Epoxy.AddNewRecipeController;
import com.vladgeorgescu.recipesforhappiness.Model.Ingredient;
import com.vladgeorgescu.recipesforhappiness.Model.Recipe;
import com.vladgeorgescu.recipesforhappiness.Model.Step;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddNewRecipeActivity extends AppCompatActivity {


    @BindView(R.id.add_recipe_toolbar)
    Toolbar addRecipeToolbar;
    @BindView(R.id.add_new_recipe_recyclerView)
    EpoxyRecyclerView addRecipeRecyclerView;

    private AddNewRecipeController addNewRecipeController= new AddNewRecipeController();

    private List<Recipe> recipes;
    private Recipe recipe;
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
        ingredientAndStepListsInit();
        addRecipeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        addRecipeRecyclerView.setControllerAndBuildModels(addNewRecipeController);

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

    private void ingredientAndStepListsInit() {
        recipeIngredients.add(new Ingredient("", ""));
        recipeSteps.add(new Step(""));

    }
}

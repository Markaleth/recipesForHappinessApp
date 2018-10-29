package com.vladgeorgescu.recipesforhappiness;


import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.common.util.Strings;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.vladgeorgescu.recipesforhappiness.Adapters.Ingredients.IngredientsViewAdapter;
import com.vladgeorgescu.recipesforhappiness.Adapters.Recipe.RecyclerViewAdapter;
import com.vladgeorgescu.recipesforhappiness.Model.Ingredient;
import com.vladgeorgescu.recipesforhappiness.Model.Recipe;
import com.vladgeorgescu.recipesforhappiness.Model.Step;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddNewRecipeActivity extends AppCompatActivity {

    @BindView(R.id.name_and_url_card)
    CardView nameAndUrlCardView;
    @BindView(R.id.recipe_name_editText)
    EditText recipeNameTextView;
    @BindView(R.id.recipe_url_editText)
    EditText recipeUrlTextView;
    @BindView(R.id.save_recipe_fab)
    FloatingActionButton saveNewRecipeFab;
    @BindView(R.id.stepsContainer)
    LinearLayout stepsLayout;
    @BindView(R.id.ingredientsContainer)
    LinearLayout ingredientsLayout;
    @BindView(R.id.stepsRecyclerView)
    RecyclerView stepsRecyclerView;
    @BindView(R.id.ingredientsRecyclerView)
    RecyclerView ingredientsRecyclerView;
    @BindView(R.id.stepsContainerLabel)
    TextView stepsContainerLable;
    @BindView(R.id.ingrediensContainerLabel)
    TextView ingredientsContainerLable;
    @BindView(R.id.add_recipe_toolbar)
    Toolbar addRecipeToolbar;
    private RecyclerViewAdapter stepsRecyclerViewAdapter;
    private RecyclerView.Adapter ingredientsRecyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Recipe> recipes;
    private Recipe recipe;
    private List<Ingredient> recipeIngredients;
    private List<Step> recipeSteps;
    private FirebaseDatabase database;
    private DatabaseReference mFirebaseReference;
    private ChildEventListener mChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_recipe);

        ButterKnife.bind(this);


        initiateToolbar();

        //Initialize Firebase objects
        database = FirebaseDatabase.getInstance();
        mFirebaseReference = database.getReference().child("recipe");

        //FAB instantiation
        saveNewRecipeFab = findViewById(R.id.save_recipe_fab);
        saveNewRecipeFab.setEnabled(false);
        saveNewRecipeFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recipe recipe = new Recipe();
                recipe.setRecipeName(recipeNameTextView.getText().toString());
                recipe.setRecipeUrl(recipeUrlTextView.getText().toString());
                mFirebaseReference.push().setValue(recipe);

//                Clear input text
                recipeNameTextView.setText("");
                recipeUrlTextView.setText("");
            }

        });


        ingredientsRecyclerViewAdapter = new IngredientsViewAdapter(this, recipeIngredients);
        ingredientsRecyclerView.setLayoutManager(new LinearLayoutManager(AddNewRecipeActivity.this));
        ingredientsRecyclerView.setAdapter(ingredientsRecyclerViewAdapter);


        recipeNameTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.toString().trim().length() > 0) {
                    saveNewRecipeFab.setEnabled(true);
                } else {
                    saveNewRecipeFab.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() > 0) {
                    saveNewRecipeFab.setEnabled(true);
                } else {
                    saveNewRecipeFab.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
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
}

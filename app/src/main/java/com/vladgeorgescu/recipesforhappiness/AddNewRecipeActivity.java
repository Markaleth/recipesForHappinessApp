package com.vladgeorgescu.recipesforhappiness;


import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import android.support.v7.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.vladgeorgescu.recipesforhappiness.Adapters.TabPageAdapter.TabPageAdapter;
import com.vladgeorgescu.recipesforhappiness.Model.Recipe;

import java.util.List;

import butterknife.ButterKnife;

public class AddNewRecipeActivity extends AppCompatActivity {

    private EditText recipeNameTextView;
    private EditText recipeUrlTextView;
    private FloatingActionButton saveNewRecipeFab;
    private List<Recipe> recipeIngredientsList;
    private TabLayout stepsAndIngredientsTabLayout;
    private ViewPager tabViewPager;
    private Toolbar addRecipeToolbar;
    private FirebaseDatabase database;
    private DatabaseReference mFirebaseReference;
    private ChildEventListener mChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_recipe);

        ButterKnife.bind(this);

        initiateToolbar();
        //View objects instance variables

        recipeNameTextView = findViewById(R.id.recipe_name_editText);
        recipeUrlTextView = findViewById(R.id.recipe_url_editText);

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

        stepsAndIngredientsTabLayout = findViewById(R.id.steps_and_ingredients_tab_layout);
        tabViewPager = findViewById(R.id.tab_view_pager);
        tabViewPager.setAdapter(new TabPageAdapter(getSupportFragmentManager()));
        stepsAndIngredientsTabLayout.setupWithViewPager(tabViewPager);

        stepsAndIngredientsTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {


            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override

            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

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

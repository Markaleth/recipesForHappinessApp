package com.vladgeorgescu.recipesforhappiness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.vladgeorgescu.recipesforhappiness.Model.Recipe;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.graphics.Color.RED;

public class AddNewRecipe extends AppCompatActivity {

    private EditText recipeNameTextView;
    private EditText recipeUrlTextView;
    private EditText recipeIngredientsTextView;
    private EditText recipeStepsTextView;
    private Button saveNewRecipe;

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference mFirebaseReference;
    private ChildEventListener mChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_recipe);
        ButterKnife.bind(this);

        //View objects instance variables

        recipeNameTextView = findViewById(R.id.recipe_name_editText);
        recipeUrlTextView = findViewById(R.id.recipe_url_editText);
        recipeIngredientsTextView = findViewById(R.id.recipe_ingredients_description);
        recipeStepsTextView = findViewById(R.id.recipe_steps_description);
        saveNewRecipe = findViewById(R.id.saveRecipeButton);
        saveNewRecipe.setEnabled(false);

        //Initialize Firebase objects
        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        mFirebaseReference = database.getReference().child("recipe");


        recipeNameTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.toString().trim().length() > 0) {
                    saveNewRecipe.setEnabled(true);
                } else {
                    saveNewRecipe.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() > 0) {
                    saveNewRecipe.setEnabled(true);
                } else {
                    saveNewRecipe.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        saveNewRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Recipe recipe = new Recipe(
                        recipeNameTextView.getText().toString(),
                        recipeUrlTextView.getText().toString(),
                        recipeIngredientsTextView.getText().toString(),
                        recipeStepsTextView.getText().toString());

                mFirebaseReference.push().setValue(recipe);

                //Clear input text
                recipeNameTextView.setText("");
                recipeUrlTextView.setText("");
                recipeIngredientsTextView.setText("");
                recipeStepsTextView.setText("");
            }
        });
    }


}

//    @OnClick(R.id.saveRecipeButton)
//    public void saveRecipe(){
//        Recipe recipe = new Recipe(
//                recipeNameTextView.getText().toString(),
//                recipeUrlTextView.getText().toString(),
//                recipeIngredientsTextView.getText().toString(),
//                recipeStepsTextView.getText().toString());
//
//        mFirebaseReference.push().setValue(recipe);
//
//    }


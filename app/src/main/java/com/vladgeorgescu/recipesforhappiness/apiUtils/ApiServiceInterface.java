package com.vladgeorgescu.recipesforhappiness.apiUtils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.vladgeorgescu.recipesforhappiness.model.Recipe;

import java.util.List;

public interface ApiServiceInterface {


    void detachDatabaseReadListener();

    List<Recipe> getRecipeList();

    void attachDatabaseReadListener();

    void attachValueEventListener();

}

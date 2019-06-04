package com.vladgeorgescu.recipesforhappiness.apiUtils;

import android.arch.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.vladgeorgescu.recipesforhappiness.model.Recipe;

import java.util.List;

public interface ApiServiceInterface {


    void detachDatabaseReadListener();

    MutableLiveData<List<Recipe>> getRecipeList();

    void attachDatabaseReadListener();

}

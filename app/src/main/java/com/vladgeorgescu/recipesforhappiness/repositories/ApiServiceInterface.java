package com.vladgeorgescu.recipesforhappiness.repositories;

import androidx.lifecycle.MutableLiveData;

import com.vladgeorgescu.recipesforhappiness.models.Recipe;

import java.util.List;

public interface ApiServiceInterface {


    void detachDatabaseReadListener();

    MutableLiveData<List<Recipe>> getRecipeList();

    void attachDatabaseReadListener();

}

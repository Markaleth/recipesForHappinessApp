package com.vladgeorgescu.recipesforhappiness.apiUtils;

import androidx.lifecycle.MutableLiveData;

import com.vladgeorgescu.recipesforhappiness.model.Recipe;

import java.util.List;

public interface ApiServiceInterface {


    void detachDatabaseReadListener();

    MutableLiveData<List<Recipe>> getRecipeList();

    void attachDatabaseReadListener();

}

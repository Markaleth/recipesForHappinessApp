package com.vladgeorgescu.recipesforhappiness.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.vladgeorgescu.recipesforhappiness.apiUtils.ApiServiceImplementation;
import com.vladgeorgescu.recipesforhappiness.apiUtils.ApiServiceInterface;
import com.vladgeorgescu.recipesforhappiness.auth.AuthUiWrapper;
import com.vladgeorgescu.recipesforhappiness.auth.Authenticator;
import com.vladgeorgescu.recipesforhappiness.model.Recipe;

import java.util.List;

public class MyRecipesViewModel extends ViewModel {

    private MutableLiveData<List<Recipe>> recipesMutableLiveData = new MutableLiveData<>();
    private Authenticator authenticator;
    private ApiServiceInterface apiService;
    private String mUsername;

    public void init() {
        authenticator = new Authenticator();
        apiService = new ApiServiceImplementation();
        listenToDatabase();
        initializeAuth();
        dataStreamInit();
    }

    public void initializeAuth() {
        authenticator.setFirebaseAuthStateListener();
        addAuthenticationStateListener();

    }

    private void addAuthenticationStateListener() {
        authenticator.getFirebaseAuth().addAuthStateListener(authenticator.getFirebaseAuthStateListener());
    }

    public void checkAuthentication() {
        if (authenticator.getFirebaseAuthStateListener() == null) {
            onSignInInitialize(mUsername);
        }
        onSignedOutCleanup();
    }

    private void onSignInInitialize(String username) {
        mUsername = username;
        apiService.attachDatabaseReadListener();
        addAuthenticationStateListener();
    }


    private void onSignedOutCleanup() {
        mUsername = "Anonymous";
        apiService.detachDatabaseReadListener();
        addAuthenticationStateListener();
    }

    private void dataStreamInit() {
        recipesMutableLiveData.setValue(apiService.getRecipeList());
    }

    private void listenToDatabase() {
        apiService.attachValueEventListener();
    }

    public LiveData<List<Recipe>> getRecipes() {
        listenToDatabase();
        return recipesMutableLiveData;
    }

}

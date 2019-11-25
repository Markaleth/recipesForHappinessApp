package com.vladgeorgescu.recipesforhappiness.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.vladgeorgescu.recipesforhappiness.repositories.ApiServiceImplementation;
import com.vladgeorgescu.recipesforhappiness.repositories.ApiServiceInterface;
import com.vladgeorgescu.recipesforhappiness.utils.Authenticator;
import com.vladgeorgescu.recipesforhappiness.models.Recipe;

import java.util.List;

public class MyRecipesViewModel extends ViewModel {

    private Authenticator authenticator;
    private ApiServiceInterface apiService;
    private String mUsername;

    public void init() {
        authenticator = new Authenticator();
        apiService = new ApiServiceImplementation();
        initializeAuth();
    }

    private void initializeAuth() {
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

    public LiveData<List<Recipe>> getRecipes() {
        return apiService.getRecipeList();
    }

}

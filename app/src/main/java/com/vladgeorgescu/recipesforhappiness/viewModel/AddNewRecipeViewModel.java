package com.vladgeorgescu.recipesforhappiness.viewModel;

import androidx.lifecycle.ViewModel;

import com.vladgeorgescu.recipesforhappiness.apiUtils.ApiServiceImplementation;
import com.vladgeorgescu.recipesforhappiness.apiUtils.ApiServiceInterface;
import com.vladgeorgescu.recipesforhappiness.auth.Authenticator;

public class AddNewRecipeViewModel extends ViewModel {

    private ApiServiceInterface apiService;

    public void init() {
        apiService = new ApiServiceImplementation();
    }
}

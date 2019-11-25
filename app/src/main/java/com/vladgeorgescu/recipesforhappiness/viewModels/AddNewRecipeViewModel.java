package com.vladgeorgescu.recipesforhappiness.viewModels;

import androidx.lifecycle.ViewModel;

import com.vladgeorgescu.recipesforhappiness.repositories.ApiServiceImplementation;
import com.vladgeorgescu.recipesforhappiness.repositories.ApiServiceInterface;

public class AddNewRecipeViewModel extends ViewModel {

    private ApiServiceInterface apiService;

    public void init() {
        apiService = new ApiServiceImplementation();
    }


}

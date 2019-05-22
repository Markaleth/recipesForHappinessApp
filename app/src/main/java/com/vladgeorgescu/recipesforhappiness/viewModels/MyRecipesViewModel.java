package com.vladgeorgescu.recipesforhappiness.viewModels;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.vladgeorgescu.recipesforhappiness.adapters.Recipe.RecyclerViewAdapter;
import com.vladgeorgescu.recipesforhappiness.apiUtils.ApiServiceImplementation;
import com.vladgeorgescu.recipesforhappiness.apiUtils.ApiServiceInterface;
import com.vladgeorgescu.recipesforhappiness.model.Recipe;

public class MyRecipesViewModel {

    private String mUsername;
    private static final int RC_SIGN_IN = 1;

    public void onSignInInitialize(String username, ApiServiceInterface apiService) {
        mUsername = username;
        attachDatabaseReadListener(apiService);
        apiService.getAuth().addAuthStateListener(apiService.getAuthStateListener());
    }

    public void attachDatabaseReadListener(ApiServiceInterface apiService) {
        if (apiService.getChildEventListener() == null) {
            apiService.setChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Recipe recipe = dataSnapshot.getValue(Recipe.class);

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
            apiService.getReference().addChildEventListener(apiService.getChildEventListener());
        }
    }

    public void detachDatabaseReadListener(ApiServiceInterface apiService) {
        if (apiService.getChildEventListener() != null) {
            apiService.getReference().removeEventListener(apiService.getChildEventListener());
            apiService.setChildEventListener(null);
        }
    }

    public void onSignedOutCleanup(ApiServiceInterface apiService) {
        mUsername = "Anonymous";
        detachDatabaseReadListener(apiService);
    }

    public static int getSignInRequestCode() {
        return RC_SIGN_IN;
    }
}

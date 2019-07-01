package com.vladgeorgescu.recipesforhappiness.auth;

import com.google.firebase.auth.FirebaseAuth;
import com.vladgeorgescu.recipesforhappiness.apiUtils.ApiServiceImplementation;
import com.vladgeorgescu.recipesforhappiness.apiUtils.ApiServiceInterface;

public class Authenticator {

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;
    private AuthUiWrapper authUiWrapper;
    private ApiServiceInterface apiService;

    public Authenticator() {
        firebaseAuth =  FirebaseAuth.getInstance();
        authUiWrapper = new AuthUiWrapper();
        apiService = new ApiServiceImplementation();
    }


    public String getUserId() {
        return firebaseAuth.getCurrentUser().getUid();
    }

    public FirebaseAuth getFirebaseAuth() {
        return firebaseAuth;
    }

    public void setFirebaseAuth(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    public FirebaseAuth.AuthStateListener getFirebaseAuthStateListener() {
        return firebaseAuthStateListener;
    }

    public void setFirebaseAuthStateListener() {
        firebaseAuthStateListener = firebaseAuth -> {
            if (firebaseAuth.getCurrentUser() != null) {
                apiService.attachDatabaseReadListener();
                firebaseAuth.addAuthStateListener(getFirebaseAuthStateListener());
            } else {
                apiService.detachDatabaseReadListener();
                getFirebaseAuth().addAuthStateListener(getFirebaseAuthStateListener());
                authUiWrapper.getAuthIntent();
            }
        };
    }
}

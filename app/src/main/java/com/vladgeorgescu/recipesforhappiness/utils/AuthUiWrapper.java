package com.vladgeorgescu.recipesforhappiness.utils;

import android.content.Intent;

import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;
import java.util.List;


public class AuthUiWrapper {

    private static final int RC_SIGN_IN = 1;

    private List<AuthUI.IdpConfig> providers = Arrays.asList(
            new AuthUI.IdpConfig.EmailBuilder().build(),
            new AuthUI.IdpConfig.GoogleBuilder().build());


    public Intent getAuthIntent() {
        return AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build();
    }

    public static int getRcSignIn() {
        return RC_SIGN_IN;
    }


}

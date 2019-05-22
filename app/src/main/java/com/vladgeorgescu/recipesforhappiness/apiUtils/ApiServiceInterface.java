package com.vladgeorgescu.recipesforhappiness.apiUtils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public interface ApiServiceInterface {

    FirebaseAuth getAuth();

    FirebaseAuth.AuthStateListener getAuthStateListener();

    void setAuthStateListener(FirebaseAuth.AuthStateListener firebaseAuthStateListener);

    ChildEventListener getChildEventListener();

    void setChildEventListener(ChildEventListener firebaseChildEventListener);

    DatabaseReference getReference();

    FirebaseDatabase getDatabase();
}

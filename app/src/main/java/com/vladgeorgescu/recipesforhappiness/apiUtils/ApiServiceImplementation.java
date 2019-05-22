package com.vladgeorgescu.recipesforhappiness.apiUtils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ApiServiceImplementation implements ApiServiceInterface {
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;
    private ChildEventListener firebaseChildEventListener;
    private DatabaseReference firebaseReference;
    private FirebaseDatabase firebaseDatabase;

    public ApiServiceImplementation (){
        this.firebaseDatabase = FirebaseDatabase.getInstance();
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.firebaseReference = firebaseDatabase.getReference().child("recipe");
    }

    public FirebaseAuth getAuth() {
        return firebaseAuth;
    }

    public void setFirebaseAuth(FirebaseAuth mFirebaseAuth) {
        this.firebaseAuth = mFirebaseAuth;
    }

    public FirebaseAuth.AuthStateListener getAuthStateListener() {
        return firebaseAuthStateListener;
    }

    public void setAuthStateListener(FirebaseAuth.AuthStateListener firebaseAuthStateListener) {
        this.firebaseAuthStateListener = firebaseAuthStateListener;
    }

    public ChildEventListener getChildEventListener() {
        return firebaseChildEventListener;
    }

    public void setChildEventListener(ChildEventListener firebaseChildEventListener) {
        this.firebaseChildEventListener = firebaseChildEventListener;
    }

    public DatabaseReference getReference() {
        return firebaseReference;
    }

    public void setFirebaseReference(DatabaseReference firebaseReference) {
        this.firebaseReference = firebaseReference;
    }

    public FirebaseDatabase getDatabase() {
        return firebaseDatabase;
    }

    public void setFirebaseDatabase(FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;
    }

}

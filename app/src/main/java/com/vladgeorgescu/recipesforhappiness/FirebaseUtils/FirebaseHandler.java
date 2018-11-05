package com.vladgeorgescu.recipesforhappiness.FirebaseUtils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHandler {
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;
    private ChildEventListener firebaseChildEventListener;
    private DatabaseReference firebaseReference;
    private FirebaseDatabase firebaseDatabase;

    public FirebaseHandler (){
        this.firebaseDatabase = FirebaseDatabase.getInstance();
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.firebaseReference = firebaseDatabase.getReference().child("recipe");
    }

    public FirebaseAuth getFirebaseAuth() {
        return firebaseAuth;
    }

    public void setFirebaseAuth(FirebaseAuth mFirebaseAuth) {
        this.firebaseAuth = mFirebaseAuth;
    }

    public FirebaseAuth.AuthStateListener getFirebaseAuthStateListener() {
        return firebaseAuthStateListener;
    }

    public void setFirebaseAuthStateListener(FirebaseAuth.AuthStateListener firebaseAuthStateListener) {
        this.firebaseAuthStateListener = firebaseAuthStateListener;
    }

    public ChildEventListener getFirebaseChildEventListener() {
        return firebaseChildEventListener;
    }

    public void setFirebaseChildEventListener(ChildEventListener firebaseChildEventListener) {
        this.firebaseChildEventListener = firebaseChildEventListener;
    }

    public DatabaseReference getFirebaseReference() {
        return firebaseReference;
    }

    public void setFirebaseReference(DatabaseReference firebaseReference) {
        this.firebaseReference = firebaseReference;
    }

    public FirebaseDatabase getFirebaseDatabase() {
        return firebaseDatabase;
    }

    public void setFirebaseDatabase(FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;
    }
}

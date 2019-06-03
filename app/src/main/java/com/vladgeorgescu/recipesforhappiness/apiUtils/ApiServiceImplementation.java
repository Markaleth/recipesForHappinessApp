package com.vladgeorgescu.recipesforhappiness.apiUtils;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vladgeorgescu.recipesforhappiness.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class ApiServiceImplementation implements ApiServiceInterface {
    private ChildEventListener firebaseChildEventListener;
    private DatabaseReference firebaseReference;
    private FirebaseDatabase firebaseDatabase;
    private List<Recipe> recipeList= new ArrayList<>();

    private String mUsername;

    public ApiServiceImplementation() {
        this.firebaseDatabase = FirebaseDatabase.getInstance();
        this.firebaseReference = firebaseDatabase.getReference().child("recipe");
        attachDatabaseReadListener();
    }

    private ValueEventListener listenerInit() {
        return new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                recipeList = new ArrayList<>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Recipe recipe = dataSnapshot1.getValue(Recipe.class);
                    recipeList.add(recipe);
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                recipeList = new ArrayList<>();
                Log.w("DATABASE READ CANCELED", "Failed to read values.", databaseError.toException());
            }
        };
    }

    private ChildEventListener getChildEventListener() {
        return firebaseChildEventListener;
    }

    private void setChildEventListener(ChildEventListener firebaseChildEventListener) {
        this.firebaseChildEventListener = firebaseChildEventListener;
    }


    public void attachValueEventListener() {
        firebaseReference.addValueEventListener(listenerInit());
    }


    public void detachDatabaseReadListener() {
        if (getChildEventListener() != null) {
            firebaseReference.removeEventListener(getChildEventListener());
            setChildEventListener(null);
        }
    }

    public List<Recipe> getRecipeList() {
        attachValueEventListener();
        Log.d("Recipe_seize", String.valueOf(recipeList.size()));
        return recipeList;
    }

    public void attachDatabaseReadListener() {

        if (firebaseChildEventListener == null) {
            firebaseChildEventListener = (new ChildEventListener() {
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
            firebaseReference.addChildEventListener(firebaseChildEventListener);
        }

    }
}

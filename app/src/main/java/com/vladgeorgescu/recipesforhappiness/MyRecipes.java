package com.vladgeorgescu.recipesforhappiness;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vladgeorgescu.recipesforhappiness.Adapters.Recipe.RecyclerViewAdapter;
import com.vladgeorgescu.recipesforhappiness.Model.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyRecipes extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static final int RC_SIGN_IN = 1;

    RecyclerViewAdapter recyclerViewAdapter;
    private String mUsername;
    RecyclerView recyclerView;
    List<Recipe> recipeList;
    public static final String ANONYMOUS = "anonymous";


    //Firebase instance variables
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private ChildEventListener mChildEventListener;
    private DatabaseReference mFirebaseReference;
    private FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recipes);
        ButterKnife.bind(this);
        recyclerView = findViewById(R.id.recipe_recyclerView);
        mUsername = ANONYMOUS;

        //Firebase variable initialisation
        database = FirebaseDatabase.getInstance();
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseReference = database.getReference().child("recipe");

        recyclerViewAdapter = new RecyclerViewAdapter(this, recipeList);
        RecyclerView.LayoutManager recycler = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(MyRecipes.this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);


        mFirebaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                recipeList = new ArrayList<>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Recipe recipeObject = dataSnapshot1.getValue(Recipe.class);
                    Recipe recipe = new Recipe();
                    assert recipeObject != null;
                    String recipeName = recipeObject.getRecipeName();
                    recipe.setRecipeName(recipeName);
                    recipeList.add(recipe);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MyRecipes.this, "Oops! We ran into some problems retrieving your recipes! Please try again later!", Toast.LENGTH_SHORT).show();
            }
        });


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    onSignInInitialize(user.getDisplayName());
                    mUsername = user.getDisplayName();
                } else {
                    onSignedOutCleanup();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.EmailBuilder().build(),
                                            new AuthUI.IdpConfig.GoogleBuilder().build()
                                    ))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Signed in!", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Sign in canceled!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
        recyclerViewAdapter = new RecyclerViewAdapter(this, recipeList);
        RecyclerView.LayoutManager recycler = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(recycler);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
        detachDatabaseReadListener();
    }


    private void onSignInInitialize(String username) {
        mUsername = username;
        attachDatabaseReadListener();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
        recyclerViewAdapter = new RecyclerViewAdapter(this, recipeList);
        RecyclerView.LayoutManager recycler = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(recycler);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void onSignedOutCleanup() {
        mUsername = "Anonymous";
        detachDatabaseReadListener();
    }

    @OnClick(R.id.floatingActionButtonMyCreationsTab)
    public void addNewRecipe() {
        Intent intent = new Intent(this, AddNewRecipe.class);
        startActivity(intent);

    }

    protected void attachDatabaseReadListener() {

        if (mChildEventListener == null) {
            mChildEventListener = new ChildEventListener() {
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
            };

            mFirebaseReference.addChildEventListener(mChildEventListener);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sign_out_menu:
                AuthUI.getInstance().signOut(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void detachDatabaseReadListener() {

        if (mChildEventListener != null) {
            mFirebaseReference.removeEventListener(mChildEventListener);
            mChildEventListener = null;
        }

    }
}



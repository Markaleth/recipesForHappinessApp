package com.vladgeorgescu.recipesforhappiness;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.vladgeorgescu.recipesforhappiness.Adapters.RecyclerViewAdapter;

import java.util.Arrays;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyRecipes extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static final int RC_SIGN_IN = 1;

    RecyclerViewAdapter recyclerViewAdapter;
    private String mUsername;
    RecyclerView recipeHolderRecyclerView;
    String recipeName[];
    public static final String ANONYMOUS = "anonymous";


    //Firebase instance variables
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recipes);
        recipeHolderRecyclerView = findViewById(R.id.recipe_recyclerView);

        recipeName = getResources().getStringArray(R.array.recipeNames);
        recyclerViewAdapter = new RecyclerViewAdapter(this, recipeName);

        recipeHolderRecyclerView.setAdapter(recyclerViewAdapter);
        recipeHolderRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ButterKnife.bind(this);


        mUsername = ANONYMOUS;

        //Firebase variable initialisation
        mFirebaseAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    onSignInInitialize(user.getDisplayName());
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
//        } else if (requestCode == RC_PHOTO_PICKER && resultCode == RESULT_OK) {
//            Uri selectedImageUri = data.getData();

//            StorageReference photoRef = mChatPhotoStorageReference.child(selectedImageUri.getLastPathSegment());
//
//            photoRef.putFile(selectedImageUri)
//                    .addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            Uri downloadUrl = taskSnapshot.getDownloadUrl();
//
//                            MyRecipes friendlyMessage = new FriendlyMessage(null, mUsername, downloadUrl.toString());
//                            mMessagesDatabaseReference.push().setValue(friendlyMessage);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
//        detachDatabaseReadListener();
//        mMessageAdapter.clear();
    }

    private void onSignInInitialize(String username) {
        mUsername = username;
//        attachDatabaseReadListener();
    }

    private void onSignedOutCleanup() {
        mUsername = ANONYMOUS;
//        mMessageAdapter.clear();

    }

    @OnClick(R.id.floatingActionButtonMyCreationsTab)
    public void addNewRecipe() {
        Intent intent = new Intent(this, AddNewRecipe.class);
        startActivity(intent);

    }
}

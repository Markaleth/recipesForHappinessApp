package com.vladgeorgescu.recipesforhappiness;

import android.content.Intent;


import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.vladgeorgescu.recipesforhappiness.adapters.Recipe.RecyclerViewAdapter;
import com.vladgeorgescu.recipesforhappiness.apiUtils.ApiServiceImplementation;
import com.vladgeorgescu.recipesforhappiness.apiUtils.ApiServiceInterface;
import com.vladgeorgescu.recipesforhappiness.model.Recipe;
import com.vladgeorgescu.recipesforhappiness.viewModels.MyRecipesViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.vladgeorgescu.recipesforhappiness.viewModels.MyRecipesViewModel.getSignInRequestCode;

public class MyRecipesActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private String mUsername;
    ApiServiceInterface apiService;
    ArrayList<Recipe> recipeList;

    RecyclerViewAdapter recyclerViewAdapter;
    @BindView(R.id.recipe_recyclerView)
    RecyclerView recyclerView;
    Toolbar myRecipiesToolbar;
    public static final String ANONYMOUS = "anonymous";

    MyRecipesViewModel recipesViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recipes);
        ButterKnife.bind(this);
        apiService = new ApiServiceImplementation();

        myRecipiesToolbar = findViewById(R.id.my_recipes_toolbar);
        setSupportActionBar(myRecipiesToolbar);

        recipesViewModel = new MyRecipesViewModel();

        recyclerViewAdapter = new RecyclerViewAdapter(this, recipeList);
        RecyclerView.LayoutManager recycler = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(recycler);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);

        apiService.getReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                recipeList = new ArrayList<>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Recipe recipe = dataSnapshot1.getValue(Recipe.class);
                    recipeList.add(recipe);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MyRecipesActivity.this, "Oops! We ran into some problems retrieving your recipes! Please try again later!", Toast.LENGTH_SHORT).show();
            }
        });

        apiService.setAuthStateListener(firebaseAuth -> {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user != null) {
                recipesViewModel.onSignInInitialize(user.getDisplayName(), apiService);
                recyclerViewAdapter.updateItemList(recipeList);
                mUsername = user.getDisplayName();
            } else {
                recipesViewModel.onSignedOutCleanup(apiService);
                startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setIsSmartLockEnabled(false)
                                .setAvailableProviders(Arrays.asList(
                                        new AuthUI.IdpConfig.EmailBuilder().build(),
                                        new AuthUI.IdpConfig.GoogleBuilder().build()
                                ))
                                .build(),
                        getSignInRequestCode());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == getSignInRequestCode()) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Signed in!", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Sign in canceled!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        apiService.getReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                recipeList = new ArrayList<>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Recipe recipe = dataSnapshot1.getValue(Recipe.class);
                    recipeList.add(recipe);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MyRecipesActivity.this, "Oops! We ran into some problems retrieving your recipes! Please try again later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        apiService.getAuth().addAuthStateListener(apiService.getAuthStateListener());
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (apiService.getAuthStateListener() != null) {
            apiService.getAuth().removeAuthStateListener(apiService.getAuthStateListener());
        }
        recipesViewModel.detachDatabaseReadListener(apiService);
    }

    @OnClick(R.id.floatingActionButtonMyCreationsTab)
    public void addNewRecipe() {
        Intent intent = new Intent(this, AddNewRecipeActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sign_out_menu:
                AuthUI.getInstance().signOut(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}



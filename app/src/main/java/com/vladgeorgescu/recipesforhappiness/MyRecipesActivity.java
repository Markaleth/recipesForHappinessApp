package com.vladgeorgescu.recipesforhappiness;

import android.content.Intent;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.firebase.ui.auth.AuthUI;
import com.vladgeorgescu.recipesforhappiness.adapters.RecipeView;
import com.vladgeorgescu.recipesforhappiness.models.Recipe;
import com.vladgeorgescu.recipesforhappiness.viewModels.MyRecipesViewModel;
import com.xwray.groupie.GroupAdapter;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyRecipesActivity extends AppCompatActivity {

    @BindView(R.id.recipe_recyclerView)
    RecyclerView recyclerView;

    private MyRecipesViewModel recipesViewModel;
    private GroupAdapter groupAdapter = new GroupAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recipes);
        ButterKnife.bind(this);

        Toolbar myRecipiesToolbar = findViewById(R.id.my_recipes_toolbar);
        setSupportActionBar(myRecipiesToolbar);

        recipesViewModel = new MyRecipesViewModel();
        recipesViewModel.init();

        observeRecipesResponse();
        setupRecyclerView();
    }


    private void observeRecipesResponse() {
        recipesViewModel.getRecipes().observe(this, recipes -> {
            groupAdapter.clear();
            for (Recipe recipe : recipes){
                groupAdapter.add(new RecipeView(recipe));
            }
        });
    }

    private void setupRecyclerView(){
        groupAdapter = new GroupAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(groupAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        observeRecipesResponse();
    }


    @Override
    protected void onResume() {
        super.onResume();
        recipesViewModel.checkAuthentication();
        observeRecipesResponse();
    }

    @OnClick(R.id.addNewRecipeButton)
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
        if (item.getItemId() == R.id.sign_out_menu) {
            AuthUI.getInstance().signOut(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}



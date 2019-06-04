package com.vladgeorgescu.recipesforhappiness;

import android.arch.lifecycle.Observer;
import android.content.Intent;


import android.os.Bundle;

import android.support.annotation.Nullable;
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
import com.vladgeorgescu.recipesforhappiness.adapters.Recipe.RecyclerViewAdapter;
import com.vladgeorgescu.recipesforhappiness.model.Recipe;
import com.vladgeorgescu.recipesforhappiness.viewModel.MyRecipesViewModel;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyRecipesActivity extends AppCompatActivity {

    RecyclerViewAdapter recyclerViewAdapter;
    @BindView(R.id.recipe_recyclerView)
    RecyclerView recyclerView;

    Toolbar myRecipiesToolbar;

    MyRecipesViewModel recipesViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recipes);
        ButterKnife.bind(this);

        myRecipiesToolbar = findViewById(R.id.my_recipes_toolbar);
        setSupportActionBar(myRecipiesToolbar);

        recipesViewModel = new MyRecipesViewModel();
        recipesViewModel.init();

        observeRecipesResponse();
        recyclerViewAdapter = new RecyclerViewAdapter(this, recipesViewModel.getRecipes().getValue());

        RecyclerView.LayoutManager recycler = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(recycler);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        recyclerView.setAdapter(recyclerViewAdapter);
    }


    private void observeRecipesResponse(){
        recipesViewModel.getRecipes().observe(this, recipes -> recyclerViewAdapter.updateItemList(recipes));
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
        if (item.getItemId() == R.id.sign_out_menu) {
            AuthUI.getInstance().signOut(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}



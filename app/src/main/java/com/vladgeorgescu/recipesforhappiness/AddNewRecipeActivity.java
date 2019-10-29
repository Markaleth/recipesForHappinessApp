package com.vladgeorgescu.recipesforhappiness;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cruxlab.sectionedrecyclerview.lib.SectionDataManager;
import com.vladgeorgescu.recipesforhappiness.adapters.Ingredient.IngredientAdapter;
import com.vladgeorgescu.recipesforhappiness.viewModel.AddNewRecipeViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddNewRecipeActivity extends AppCompatActivity {

    private LinearLayoutManager linearLayoutManager;
    private AddNewRecipeViewModel viewModel;
    private SectionDataManager sectionDataManager;
    RecyclerView.Adapter adapter;

    Toolbar addNewRecipeToolbar;

    @BindView(R.id.recipeContents)
    public RecyclerView recipeContentsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_recipe);
        ButterKnife.bind(this);

        addNewRecipeToolbar = findViewById(R.id.my_recipes_toolbar);
        setSupportActionBar(addNewRecipeToolbar);

        viewModel = new AddNewRecipeViewModel();
        viewModel.init();

        recipeContentsRecyclerView.setLayoutManager(linearLayoutManager);
        recipeContentsRecyclerView.setItemAnimator(new DefaultItemAnimator());


        sectionDataManager = new SectionDataManager();
        adapter = sectionDataManager.getAdapter();

        recipeContentsRecyclerView.setAdapter(adapter);



        setContentView(R.layout.activity_add_new_recipe);
        setSupportActionBar(addNewRecipeToolbar);


    }

}

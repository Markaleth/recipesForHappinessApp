package com.vladgeorgescu.recipesforhappiness;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.google.android.material.tabs.TabLayout;
import com.vladgeorgescu.recipesforhappiness.adapters.SectionsPageAdapter;
import com.vladgeorgescu.recipesforhappiness.viewModels.AddNewRecipeViewModel;
import com.vladgeorgescu.recipesforhappiness.views.CellViewAdapter;
import com.vladgeorgescu.recipesforhappiness.views.ItemFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

import static androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL;

public class AddNewRecipeActivity extends AppCompatActivity {

    private AddNewRecipeViewModel viewModel;
    Toolbar addNewRecipeToolbar;
    CellViewAdapter adapter;


    private SectionsPageAdapter sectionsPageAdapter;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_recipe);
        ButterKnife.bind(this);

        addNewRecipeToolbar = findViewById(R.id.my_recipes_toolbar);
        setSupportActionBar(addNewRecipeToolbar);

        adapter = new CellViewAdapter();
        adapter.items.add(0, "");

        setupViewPager();
    }

    private void setupViewPager(){
        sectionsPageAdapter= new SectionsPageAdapter(getSupportFragmentManager());
        sectionsPageAdapter.addFragment(new ItemFragment(), "Ingredients");
        sectionsPageAdapter.addFragment(new ItemFragment(), "Steps");
    }
}

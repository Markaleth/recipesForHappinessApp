package com.vladgeorgescu.recipesforhappiness.TabFragments;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.vladgeorgescu.recipesforhappiness.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class IngredientsTabFragment extends Fragment {

    private Unbinder unbinder;
    private EditText ingredientName;
    private FloatingActionButton addExtraIngredient;
    private LinearLayout ingredientsLinerarLayout;
    private Context context;
    private CardView ingredientCardView;

    public IngredientsTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.ingredient_tab_fragment, container, false);
        ingredientsLinerarLayout = view.findViewById(R.id.ingredients_layout);
        ingredientCardView = view.findViewById(R.id.addIngredientCardView);
        ingredientName = view.findViewById(R.id.ingredientName);
        addExtraIngredient = view.findViewById(R.id.addIngredientFab);
        ButterKnife.bind(getActivity());
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.addIngredientFab})
    public void addNewIngredientRow() {

    }

}

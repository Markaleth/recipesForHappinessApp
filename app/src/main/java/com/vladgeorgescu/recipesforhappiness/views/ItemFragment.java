package com.vladgeorgescu.recipesforhappiness.views;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.vladgeorgescu.recipesforhappiness.R;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ItemFragment extends Fragment {

    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.add_recipe_form_cell, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }
}
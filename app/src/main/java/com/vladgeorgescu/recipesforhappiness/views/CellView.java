package com.vladgeorgescu.recipesforhappiness.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vladgeorgescu.recipesforhappiness.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CellView extends FrameLayout {

    @BindView(R.id.addCellCardView)
    CardView cellCardView;

    @BindView(R.id.cellContainer)
    RelativeLayout cellContainer;

    @BindView(R.id.cellName)
    EditText cellNameTextView;

    @BindView(R.id.addCellFab)
    FloatingActionButton addNewCellFab;


    public CellView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.add_recipe_form_cell, this);
        ButterKnife.bind(this);
    }

    public EditText getCellNameTextView() {
        return cellNameTextView;
    }

    public FloatingActionButton getAddNewCellFab() {
        return addNewCellFab;
    }
}

package com.vladgeorgescu.recipesforhappiness.views;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

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



    public CellView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.add_recipe_form_cell, this);
        ButterKnife.bind(this);
    }
}

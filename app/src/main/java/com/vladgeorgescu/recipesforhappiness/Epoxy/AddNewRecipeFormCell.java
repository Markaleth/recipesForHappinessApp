package com.vladgeorgescu.recipesforhappiness.Epoxy;


import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.vladgeorgescu.recipesforhappiness.R;

import butterknife.BindView;

import static com.airbnb.epoxy.EpoxyAttribute.Option.DoNotHash;

@EpoxyModelClass(layout = R.layout.add_recipe_form_cell)
public class AddNewRecipeFormCell extends EpoxyModelWithHolder<AddNewRecipeFormCell.FormCellHolder> {

    @EpoxyAttribute
    @StringRes
    int hintText;
    @EpoxyAttribute(DoNotHash)
    OnClickListener cellFabOnClickListener;

    @Override
    protected FormCellHolder createNewHolder() {
        return new FormCellHolder();
    }

    @Override
    public void bind(@NonNull final FormCellHolder holder) {
        holder.cellName.setHint(hintText);
        holder.addCellFab.setOnClickListener(cellFabOnClickListener);
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.add_recipe_form_cell;
    }

    class FormCellHolder extends BaseEpoxyHolder {
        @BindView(R.id.cell_element_name)
        EditText cellName;
        @BindView(R.id.addCellFab)
        FloatingActionButton addCellFab;
        @BindView(R.id.addCellCardView)
        CardView cellCardView;
        @BindView(R.id.cell_constraintLayout)
        ConstraintLayout cellConstraintLayout;
    }
}

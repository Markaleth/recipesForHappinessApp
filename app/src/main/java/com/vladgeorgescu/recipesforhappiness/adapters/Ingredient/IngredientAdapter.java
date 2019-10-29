package com.vladgeorgescu.recipesforhappiness.adapters.Ingredient;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.cruxlab.sectionedrecyclerview.lib.BaseSectionAdapter;
import com.cruxlab.sectionedrecyclerview.lib.SectionAdapter;
import com.vladgeorgescu.recipesforhappiness.R;
import com.vladgeorgescu.recipesforhappiness.adapters.RecyclerClickListener;

import java.util.ArrayList;

import butterknife.BindView;

public class IngredientAdapter extends SectionAdapter<IngredientAdapter.ItemHolder, IngredientAdapter.ItemHeaderHolder> {

    private ArrayList<String> ingredients;


    public IngredientAdapter(boolean isHeaderVisible, boolean isHeaderPinned) {
        super(isHeaderVisible, isHeaderPinned);
//        ingredients = new ArrayList<>();
//        ingredients.add(" ");
    }

    @Override
    public IngredientAdapter.ItemHeaderHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View headerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredients_healder, parent, false);
        return new ItemHeaderHolder(headerView);
    }

    @Override
    public void onBindHeaderViewHolder(IngredientAdapter.ItemHeaderHolder holder) {
        holder.bindHeader();
    }


    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    @Override
    public IngredientAdapter.ItemHolder onCreateItemViewHolder(ViewGroup parent, short type) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_recipe_form_cell, parent, false);
        return new ItemHolder(itemView);
    }

    @Override
    public void onBindItemViewHolder(IngredientAdapter.ItemHolder holder, int position) {
        holder.bindItem();
    }


    static class ItemHolder extends BaseSectionAdapter.ItemViewHolder {

        @BindView(R.id.addCellCardView)
        CardView itemCellCardView;

        @BindView(R.id.cellName)
        EditText itemNameTextView;

        @BindView(R.id.addCellFab)
        EditText addNewCellFab;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bindItem() {
            itemNameTextView.setHint(R.string.recipe_ingredients_text_input_hint);
        }
    }

    static class ItemHeaderHolder extends BaseSectionAdapter.HeaderViewHolder {

        @BindView(R.id.ingredientsHeader)
        TextView ingredientsHeader;

        public ItemHeaderHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bindHeader() {
            ingredientsHeader.setAllCaps(true);
        }


    }
}

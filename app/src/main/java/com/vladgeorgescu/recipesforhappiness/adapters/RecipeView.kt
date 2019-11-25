package com.vladgeorgescu.recipesforhappiness.adapters

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.recipies_row.view.*
import com.vladgeorgescu.recipesforhappiness.R
import com.vladgeorgescu.recipesforhappiness.models.Recipe
import kotlinx.android.synthetic.main.recipies_row.*


open class RecipeView(private val recipe : Recipe) : Item() {


    override fun getLayout(): Int {
        return R.layout.recipies_row
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val  context = viewHolder.containerView.recipeCardView
        viewHolder.recipeName.text = recipe.recipeName;
    }

}
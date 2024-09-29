package com.me.lordmathi2741.recipe.prototypes

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.me.lordmathi2741.recipe.R
import com.me.lordmathi2741.recipe.models.Recipe

class FavoriteRecipePrototype (view: View) : RecyclerView.ViewHolder(view) {
    val tvRecipeName = view.findViewById<TextView>(R.id.tvFavoriteRecipeName)
    val tvMealCategory = view.findViewById<TextView>(R.id.tvFavoriteMealCategory)
    val tvMealInstructions = view.findViewById<TextView>(R.id.tvFavoriteMealInstructions)
    val ivRecipe = view.findViewById<ImageView>(R.id.ivFavoriteRecipe)
    fun bind(recipe: Recipe) {
        tvRecipeName.text = recipe.name
        tvMealCategory.text = recipe.category
        tvMealInstructions.text = recipe.instructions
        Glide.with(ivRecipe.context).load(recipe.imageUrl).into(ivRecipe)
    }

}
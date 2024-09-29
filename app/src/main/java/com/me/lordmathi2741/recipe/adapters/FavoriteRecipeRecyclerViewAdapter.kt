package com.me.lordmathi2741.recipe.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.me.lordmathi2741.recipe.R
import com.me.lordmathi2741.recipe.db.AppDatabase
import com.me.lordmathi2741.recipe.models.Recipe
import com.me.lordmathi2741.recipe.prototypes.FavoriteRecipePrototype

class FavoriteRecipeRecyclerViewAdapter(private var recipes: List<Recipe>) : RecyclerView.Adapter<FavoriteRecipePrototype>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteRecipePrototype {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.favorite_recipe_card, parent, false)
        return FavoriteRecipePrototype(layout)
    }

    override fun getItemCount(): Int {
       return recipes.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateRecipes(recipes: List<Recipe>){
        this.recipes = recipes
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: FavoriteRecipePrototype, position: Int) {
        holder.bind(recipes[position])
        val btFavoriteRecipe = holder.itemView.findViewById<ImageButton>(R.id.btFavoriteRecipe)
        val database = AppDatabase.getInstance(holder.itemView.context).recipeDao()
        btFavoriteRecipe.setOnClickListener {
            Toast.makeText(holder.itemView.context, "${recipes[position].name} eliminado de favoritos", Toast.LENGTH_SHORT).show()
            database.delete(recipes[position])
            updateRecipes(database.getAll())


        }

    }
}
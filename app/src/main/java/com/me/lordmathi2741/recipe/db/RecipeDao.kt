package com.me.lordmathi2741.recipe.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.me.lordmathi2741.recipe.models.Recipe

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipes")
    fun getAll(): List<Recipe>
    @Delete
    fun delete(recipe: Recipe)
    @Insert
    fun insert(recipe: Recipe)

}
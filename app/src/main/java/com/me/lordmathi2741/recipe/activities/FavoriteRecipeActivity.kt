package com.me.lordmathi2741.recipe.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.me.lordmathi2741.recipe.R
import com.me.lordmathi2741.recipe.adapters.FavoriteRecipeRecyclerViewAdapter
import com.me.lordmathi2741.recipe.db.AppDatabase
import com.me.lordmathi2741.recipe.models.Recipe

class FavoriteRecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_favorite_recipe)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setUpRecyclerView()
        val navigationView = findViewById<BottomNavigationView>(R.id.nvMenu)
        navigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.btHome -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.btRecipe -> {
                    val intent = Intent(this, RecipeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.btFavorite -> {
                    val intent = Intent(this, FavoriteRecipeActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

    }

    private fun loadRecipes() : List<Recipe>{
         val database = AppDatabase.getInstance(this)
         val recipes = database.recipeDao().getAll()
         return recipes
    }


    private fun setUpRecyclerView(){
        val rvFavoriteRecipes = findViewById<RecyclerView>(R.id.rvFavoriteRecipe)
        rvFavoriteRecipes.adapter = FavoriteRecipeRecyclerViewAdapter(loadRecipes())
        rvFavoriteRecipes.layoutManager = LinearLayoutManager(this)
    }
}
package com.me.lordmathi2741.recipe.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.me.lordmathi2741.recipe.R
import com.me.lordmathi2741.recipe.adapters.ConcreteAdapter
import com.me.lordmathi2741.recipe.db.AppDatabase
import com.me.lordmathi2741.recipe.factories.RecipeServiceFactory
import kotlinx.coroutines.launch

class RecipeActivity : AppCompatActivity() {
    private val recipeService = RecipeServiceFactory().createRecipeServiceInstance()
    private val  adapter = ConcreteAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recipe)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val navigationView = findViewById<BottomNavigationView>(R.id.nvMenu)
        val favoriteBtn = findViewById<ImageButton>(R.id.btFavoriteRecipe)
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
       lifecycleScope.launch {
           onRecipeGenerate()
       }
        favoriteBtn.setOnClickListener {
            lifecycleScope.launch {
                Toast.makeText(this@RecipeActivity, "Recipe added to favorites", Toast.LENGTH_SHORT).show()
                addRecipeToFavorite()
            }
        }

    }

    private suspend fun onRecipeGenerate(){
        val recipe = recipeService.getRandomRecipe()
        recipe.meals.map {
            val recipeName = it.strMeal
            val recipeCategory = it.strCategory
            val recipeInstructions = it.strInstructions
            val recipeImageUrl = it.strMealThumb
            val tvRecipeName = findViewById<TextView>(R.id.tvRecipeName)
            val tvMealCategory = findViewById<TextView>(R.id.tvMealCategory)
            val tvMealInstructions = findViewById<TextView>(R.id.tvMealnstructions)
            tvRecipeName.text = recipeName
            tvMealCategory.text = recipeCategory
            tvMealInstructions.text = recipeInstructions
            Glide.with(this).load(recipeImageUrl).into(findViewById(R.id.ivRecipe))

        }

    }

    private suspend fun addRecipeToFavorite(){
        val database = AppDatabase.getInstance(this)
        val recipeDao = database.recipeDao()
        val recipeResponse = recipeService.getRandomRecipe()
        val recipe = adapter.responseToModel(recipeResponse.meals[0])
        recipeDao.insert(recipe)
    }
}
package com.me.lordmathi2741.recipe.activities
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.me.lordmathi2741.recipe.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
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
}
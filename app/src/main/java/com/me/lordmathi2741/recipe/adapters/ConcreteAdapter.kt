package com.me.lordmathi2741.recipe.adapters

import com.me.lordmathi2741.recipe.communication.RecipeDataResponse
import com.me.lordmathi2741.recipe.models.Recipe

class ConcreteAdapter : Adapter {
    override fun responseToModel(response: RecipeDataResponse): Recipe {
        val recipe =Recipe(null,response.strMeal,response.strCategory,response.strInstructions,response.strMealThumb)
        return recipe
    }
}
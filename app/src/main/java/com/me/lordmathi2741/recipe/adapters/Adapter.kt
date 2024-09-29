package com.me.lordmathi2741.recipe.adapters

import com.me.lordmathi2741.recipe.communication.RecipeDataResponse
import com.me.lordmathi2741.recipe.models.Recipe

interface Adapter {
    fun responseToModel( response: RecipeDataResponse) : Recipe
}
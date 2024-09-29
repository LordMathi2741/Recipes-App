package com.me.lordmathi2741.recipe.network

import com.me.lordmathi2741.recipe.communication.RecipeDataResponse
import com.me.lordmathi2741.recipe.communication.RecipeWrapperResponse
import com.me.lordmathi2741.recipe.constants.Constants
import com.me.lordmathi2741.recipe.models.Recipe
import retrofit2.Call
import retrofit2.http.GET

interface RecipeService {
    @GET(Constants.RESOURCE_PATH)
    suspend fun getRandomRecipe(): RecipeWrapperResponse
    @GET(Constants.SEARCH_PATH)
    suspend fun getRecipeByName(name: String): RecipeDataResponse
}
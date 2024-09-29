package com.me.lordmathi2741.recipe.factories

import com.me.lordmathi2741.recipe.constants.Constants
import com.me.lordmathi2741.recipe.network.RecipeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeServiceFactory {
    fun createRecipeServiceInstance(): RecipeService{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeService::class.java)
    }
}
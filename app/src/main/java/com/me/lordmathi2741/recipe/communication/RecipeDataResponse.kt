package com.me.lordmathi2741.recipe.communication

import com.google.gson.annotations.SerializedName

data class RecipeDataResponse (
    @SerializedName("strMeal")
    val strMeal: String,
    @SerializedName("strCategory")
    val strCategory: String,
    @SerializedName("strInstructions")
    val strInstructions: String,
    @SerializedName("strMealThumb")
    val strMealThumb: String
)
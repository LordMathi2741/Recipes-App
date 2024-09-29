package com.me.lordmathi2741.recipe.communication

import com.google.gson.annotations.SerializedName

data class RecipeWrapperResponse(
    @SerializedName("meals")
    val meals: List<RecipeDataResponse>
)
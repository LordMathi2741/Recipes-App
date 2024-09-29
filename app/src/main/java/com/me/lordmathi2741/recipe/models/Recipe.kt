package com.me.lordmathi2741.recipe.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val category: String,
    @ColumnInfo
    val instructions: String,
    @ColumnInfo
    val imageUrl: String
)
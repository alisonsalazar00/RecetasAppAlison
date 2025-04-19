package com.alison.salazar.ulatina.recetasapp.project.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alison.salazar.ulatina.recetasapp.project.data.database.interfaces.FavoriteRecipeDao
import com.alison.salazar.ulatina.recetasapp.project.model.FavoriteRecipe

@Database(
    entities = [FavoriteRecipe::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteRecipeDao(): FavoriteRecipeDao
}
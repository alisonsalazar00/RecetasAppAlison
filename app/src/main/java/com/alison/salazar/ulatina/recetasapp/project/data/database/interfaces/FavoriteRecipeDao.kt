package com.alison.salazar.ulatina.recetasapp.project.data.database.interfaces

import androidx.room.*
import com.alison.salazar.ulatina.recetasapp.project.model.FavoriteRecipe

@Dao
interface FavoriteRecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(recipe: FavoriteRecipe)

    @Delete
    suspend fun deleteFavorite(recipe: FavoriteRecipe)

    @Query("SELECT * FROM favorite_recipes")
    suspend fun getAllFavorites(): List<FavoriteRecipe>

    @Query("SELECT * FROM favorite_recipes WHERE id = :id")
    suspend fun getFavoriteById(id: Int): FavoriteRecipe?
}
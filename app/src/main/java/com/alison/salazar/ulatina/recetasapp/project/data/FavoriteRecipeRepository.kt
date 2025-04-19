package com.alison.salazar.ulatina.recetasapp.project.data


import com.alison.salazar.ulatina.recetasapp.project.data.database.interfaces.FavoriteRecipeDao
import com.alison.salazar.ulatina.recetasapp.project.model.FavoriteRecipe
import javax.inject.Inject

class FavoriteRecipeRepository @Inject constructor(
    private val favoriteRecipeDao: FavoriteRecipeDao
) {

    suspend fun addToFavorites(recipe: FavoriteRecipe) {
        favoriteRecipeDao.insertFavorite(recipe)
    }

    suspend fun removeFromFavorites(recipe: FavoriteRecipe) {
        favoriteRecipeDao.deleteFavorite(recipe)
    }

    suspend fun getAllFavorites(): List<FavoriteRecipe> {
        return favoriteRecipeDao.getAllFavorites()
    }

    suspend fun isFavorite(id: Int): Boolean {
        return favoriteRecipeDao.getFavoriteById(id) != null
    }
}
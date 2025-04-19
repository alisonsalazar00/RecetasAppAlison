package com.alison.salazar.ulatina.recetasapp.project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alison.salazar.ulatina.recetasapp.project.data.FavoriteRecipeRepository
import com.alison.salazar.ulatina.recetasapp.project.model.FavoriteRecipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteRecipeViewModel @Inject constructor(
    private val repository: FavoriteRecipeRepository
) : ViewModel() {

    private val _favorites = MutableStateFlow<List<FavoriteRecipe>>(emptyList())
    val favorites: StateFlow<List<FavoriteRecipe>> = _favorites

    fun loadFavorites() {
        viewModelScope.launch {
            _favorites.value = repository.getAllFavorites()
        }
    }

    fun addFavorite(recipe: FavoriteRecipe) {
        viewModelScope.launch {
            repository.addToFavorites(recipe)
            loadFavorites()
        }
    }

    fun removeFavorite(recipe: FavoriteRecipe) {
        viewModelScope.launch {
            repository.removeFromFavorites(recipe)
            loadFavorites()
        }
    }

    fun isFavorite(id: Int, callback: (Boolean) -> Unit) {
        viewModelScope.launch {
            val result = repository.isFavorite(id)
            callback(result)
        }
    }
}
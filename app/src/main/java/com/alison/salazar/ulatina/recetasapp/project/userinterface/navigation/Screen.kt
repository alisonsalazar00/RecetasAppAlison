package com.alison.salazar.ulatina.recetasapp.project.userinterface.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object Explore : Screen("explore")
    object Favorites : Screen("favorites")
    object Profile : Screen("profile")
    object RecipeDetail : Screen("recipeDetail/{recipeId}") {
        fun createRoute(recipeId: Int): String = "recipeDetail/$recipeId"
    }
}
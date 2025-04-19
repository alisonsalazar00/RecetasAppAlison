package com.alison.salazar.ulatina.recetasapp.project.userinterface.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alison.salazar.ulatina.recetasapp.project.userinterface.screens.HomeScreen
import com.alison.salazar.ulatina.recetasapp.project.userinterface.screens.LoginScreen
import com.alison.salazar.ulatina.recetasapp.project.userinterface.screens.ExploreScreen
import com.alison.salazar.ulatina.recetasapp.project.userinterface.screens.FavoritesScreen
import com.alison.salazar.ulatina.recetasapp.project.userinterface.screens.ProfileScreen
import com.alison.salazar.ulatina.recetasapp.project.userinterface.screens.RecipeDetailScreen
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.alison.salazar.ulatina.recetasapp.project.viewmodel.FavoriteRecipeViewModel


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Explore.route) { ExploreScreen(navController) } // ← Solo esta
        composable(Screen.Favorites.route) { FavoritesScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
        composable(
            route = Screen.RecipeDetail.route,
            arguments = listOf(navArgument("recipeId") { type = NavType.IntType })
        ) { backStackEntry ->
            val recipeId = backStackEntry.arguments?.getInt("recipeId") ?: -1
            val viewModel: FavoriteRecipeViewModel = hiltViewModel(backStackEntry)
            RecipeDetailScreen(
                navController = navController,
                recipeId = recipeId,
                viewModel = viewModel
            )
        }
    }
}


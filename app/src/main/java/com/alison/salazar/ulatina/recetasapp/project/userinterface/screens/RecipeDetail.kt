package com.alison.salazar.ulatina.recetasapp.project.userinterface.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.alison.salazar.ulatina.recetasapp.project.data.getDummyRecipes
import androidx.hilt.navigation.compose.hiltViewModel
import com.alison.salazar.ulatina.recetasapp.project.model.FavoriteRecipe
import com.alison.salazar.ulatina.recetasapp.project.viewmodel.FavoriteRecipeViewModel
import androidx.compose.runtime.*
import androidx.navigation.NavBackStackEntry

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailScreen(    navController: NavController,
                           recipeId: Int,
                           viewModel: FavoriteRecipeViewModel
) {
    val recipe = getDummyRecipes().find { it.id == recipeId }
    println(" ID recibido: $recipeId")
    if (recipe == null) {
        println(" Receta no encontrada con ID: $recipeId")
        Text("Receta no encontrada")
        return
    }

    var isFavorite by remember { mutableStateOf(false) }

    LaunchedEffect(recipeId) {
        viewModel.isFavorite(recipeId) { result ->
            isFavorite = result
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(recipe?.title ?: "Receta") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { innerPadding ->
        recipe?.let {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(recipe.imageUrl),
                    contentDescription = recipe.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text("Ingredientes", style = MaterialTheme.typography.titleMedium)
                recipe.ingredients.forEach { ingredient ->
                    Text("- $ingredient", style = MaterialTheme.typography.bodyMedium)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text("Preparación", style = MaterialTheme.typography.titleMedium)
                recipe.steps.forEachIndexed { index, step ->
                    Text("${index + 1}. $step", style = MaterialTheme.typography.bodyMedium)
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text("Tiempo: ${recipe.time} | Dificultad: ${recipe.difficulty}")

                Spacer(modifier = Modifier.height(24.dp))

                //Este botón ya está correcto
                Button(
                    onClick = {
                        val fav = FavoriteRecipe(
                            id = recipe.id,
                            title = recipe.title,
                            description = recipe.description,
                            imageUrl = recipe.imageUrl
                        )
                        if (!isFavorite) {
                            viewModel.addFavorite(fav)
                            isFavorite = true
                        } else {
                            viewModel.removeFavorite(fav)
                            isFavorite = false
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isFavorite) Color.Gray else Color(0xFFF0B5B5)
                    )
                ) {
                    Text(if (isFavorite) "Eliminar de Favoritos" else "Guardar en Favoritos")
                }
            }
        }
    }
}
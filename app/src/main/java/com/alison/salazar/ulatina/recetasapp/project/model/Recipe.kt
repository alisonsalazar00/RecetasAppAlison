package com.alison.salazar.ulatina.recetasapp.project.model

data class Recipe(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val ingredients: List<String>,
    val steps: List<String>,
    val time: String,
    val difficulty: String
)
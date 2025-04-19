package com.alison.salazar.ulatina.recetasapp.project.data

import com.alison.salazar.ulatina.recetasapp.project.model.Recipe

fun getDummyRecipes(): List<Recipe> {
    return listOf(
        Recipe(
            id = 1,
            title = "Cheesecake de Fresa",
            description = "Delicioso cheesecake con base de galleta",
            imageUrl = "https://images.unsplash.com/photo-1606788075761-8f3d29d6584c",
            ingredients = listOf("200g galletas", "100g mantequilla", "300g queso crema", "Fresas frescas", "100g azúcar"),
            steps = listOf("Triturar galletas y mezclar con mantequilla", "Formar base y refrigerar", "Batir queso y azúcar", "Verter mezcla sobre base", "Decorar con fresas"),
            time = "1h 20min",
            difficulty = "Media"
        ),
        Recipe(
            id = 2,
            title = "Cupcakes de Vainilla",
            description = "Esponjosos y decorados con betún rosa",
            imageUrl = "https://images.unsplash.com/photo-1578985545062-69928b1d9587",
            ingredients = listOf("2 huevos", "200g harina", "100g mantequilla", "1 cdita vainilla", "Betún rosa"),
            steps = listOf("Batir huevos con mantequilla", "Agregar harina y vainilla", "Rellenar moldes", "Hornear 25 min", "Decorar con betún"),
            time = "45 min",
            difficulty = "Fácil"
        )
    )
}
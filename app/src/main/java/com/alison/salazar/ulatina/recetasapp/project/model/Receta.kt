package com.alison.salazar.ulatina.recetasapp.project.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.TypeConverter

data class Receta(
    @PrimaryKey
    val id: String = "",
    val nombre: String = "",
    val descripcion: String = "",
    val ingredientes: List<String> = emptyList(),
    val pasos: List<String> = emptyList(),
    val imagenUrl: String = "",
    val tiempo: String = "",
    val dificultad: String = "",
    val favorito: Boolean = false
)
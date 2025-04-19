package com.alison.salazar.ulatina.recetasapp.project.userinterface.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alison.salazar.ulatina.recetasapp.project.userinterface.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Buscar Receta") },
            trailingIcon = { Icon(Icons.Default.Close, contentDescription = null) },
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        // Icono e info de la app
        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = null,
            tint = Color(0xFFF0B5B5),
            modifier = Modifier.size(80.dp)
        )

        Text("Recetas App", style = MaterialTheme.typography.headlineMedium)
        Text("by Alison Salazar", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { navController.navigate(Screen.Explore.route) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF0B5B5)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .height(56.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Explorar Recetas")
        }

        Button(
            onClick = { navController.navigate(Screen.Favorites.route) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF0B5B5)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .height(56.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Favoritos")
        }

        Button(
            onClick = { navController.navigate(Screen.Profile.route) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF0B5B5)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .height(56.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Perfil")
        }
    }
}
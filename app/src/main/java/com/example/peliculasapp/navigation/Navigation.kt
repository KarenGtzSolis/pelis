package com.example.peliculasapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
//import com.example.peliculaspp.screens.details.DetailsScreen
//import com.example.peliculaspp.screens.home.HomeScreen
import com.example.peliculasapp.navigation.Screens
import com.example.peliculasapp.screens.details.DetailsScreen
import com.example.peliculasapp.screens.home.HomeScreen


@Composable
fun Navigation () {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.HomeScreen.name ){

        // Ahora vamos a definir los destinos

        composable(Screens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        composable(
            Screens.DetailsScreen.name + "/{name}" ,

            arguments = listOf(

                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Sin nombre"
                    nullable = false
                }

            )

        ) { entry ->
            DetailsScreen(name = entry.arguments?.getString("name"))
        }
    }

}
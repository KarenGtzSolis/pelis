package com.example.peliculasapp.screens.home

import android.graphics.Movie
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.peliculasapp.navigation.Screens



@Composable
fun HomeScreen(navController: NavController) {




    val movieList: List<String> = listOf(
        "Avatar",
        "300",
        "Harry Potter",
        "Back to the Future",
        "Lord of the Rings",
        "Terminador",
        "Toy Story",
        "Interstellar",
        "The Avengers"
    )

    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            LazyColumn {
                items(items = movieList) {
                    MovieRow(movie = it) { movie ->
                        Log.d("MOVIES", "$movie")
                        //navController.navigate("movieDetail/$movie") // Navega a la pantalla de detalles con el nombre de la película
                        navController.navigate(Screens.DetailsScreen.name + "/$movie")
                    }
                }
            }
        }
    }
}


@Composable
fun MovieRow(movie: String, onItemClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                onItemClick(movie)

            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)

    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape

            ) {

                Icon(imageVector = Icons.Default.AccountBox, contentDescription = null)

            }
            Text(text = movie)
        }
    }
}


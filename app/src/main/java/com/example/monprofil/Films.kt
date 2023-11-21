package com.example.monprofil

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@Composable
fun FilmsScreen(viewModel: MainViewModel, windowClass: WindowSizeClass, navController: NavHostController) {
// Observation dans un composant compose, transforme le MutableStateFlow en une liste
    val movies by viewModel.movies.collectAsStateWithLifecycle()

    // Pour n'appeler viewModel.getMovies() qu'une seule fois = première apparition du composant Films
    LaunchedEffect(key1 = true) { viewModel.getMovies() }

    when (windowClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp), content = CardFilm(movies,navController)
            )
        }

        else -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp), content = CardFilm(movies, )
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CardFilm(movies: List<TmdbMovie>,onClick : (id:Int)->Unit): LazyGridScope.() -> Unit =
    {
        for (movie in movies) {
            items(1) {
                val imageURL = "https://image.tmdb.org/t/p/w780/" + movie.poster_path
                ElevatedCard(
                    onClick={onClick(movie.id)},
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 5.dp

                    )){
                    Column(horizontalAlignment = Alignment.CenterHorizontally){
                    AsyncImage(
                        model = imageURL,
                        contentDescription = movie.original_title
                    )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = movie.original_title,
                            style = MaterialTheme.typography.titleMedium
                        )
                }
                    Spacer(Modifier.height(10.dp))
                    Row() {
                        Spacer(Modifier.width(10.dp))
                        Text(
                            text = movie.release_date,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Spacer(Modifier.width(10.dp))
                    }

                    Spacer(Modifier.height(10.dp))
                }
            }
        }
    }





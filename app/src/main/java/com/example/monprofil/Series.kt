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
import coil.compose.AsyncImage

@Composable
fun SeriesScreen(viewModel: MainViewModel, windowClass: WindowSizeClass) {
// Observation dans un composant compose, transforme le MutableStateFlow en une liste
    val series by viewModel.series.collectAsStateWithLifecycle()

    // Pour n'appeler viewModel.getMovies() qu'une seule fois = première apparition du composant Films
    LaunchedEffect(key1 = true) { viewModel.getSeries() }

    when (windowClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp), content = CardSerie(series)
            )
        }

        else -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp), content = CardSerie(series)
            )
        }
    }
}

@Composable
private fun CardSerie(series: List<TmdbTv>): LazyGridScope.() -> Unit =
    {
        for (serie in series) {
            items(1) {
                val imageURL = "https://image.tmdb.org/t/p/w780/" + serie.poster_path
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 5.dp
                    )
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        AsyncImage(
                            model = imageURL,
                            contentDescription = serie.original_name
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = serie.original_name,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    Spacer(Modifier.height(10.dp))
                    Row() {
                        Spacer(Modifier.width(10.dp))
                        Text(
                            text = serie.first_air_date,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Spacer(Modifier.width(10.dp))
                    }

                    Spacer(Modifier.height(10.dp))
                }
            }
        }
    }








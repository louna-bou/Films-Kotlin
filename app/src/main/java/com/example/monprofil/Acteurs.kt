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
import coil.compose.AsyncImage

@Composable
fun ActeursScreen(viewModel: MainViewModel,windowClass: WindowSizeClass,navController: (Any) -> Unit
){
    // Observation dans un composant compose, transforme le MutableStateFlow en une liste
    val acteurs by viewModel.acteurs.collectAsStateWithLifecycle()

    // Pour n'appeler viewModel.getMovies() qu'une seule fois = première apparition du composant Films
    LaunchedEffect(key1 = true) { viewModel.getActeurs() }

    when (windowClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp),
                content = CardActeur(acteurs, navController)
            )
        }

        else -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp), content = CardActeur(acteurs, navController)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CardActeur(acteurs: List<TmdbActor>,onClick: (id: Int) -> Unit
): LazyGridScope.() -> Unit =
    {
        for (acteur in acteurs) {
            items(1) {
                val imageURL = "https://image.tmdb.org/t/p/w780/" + acteur.profile_path
                ElevatedCard(
                    onClick = { onClick(acteur.id) },
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 5.dp
                    )
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        AsyncImage(
                            model = imageURL,
                            contentDescription = acteur.name
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = acteur.name ,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    Spacer(Modifier.height(10.dp))
                }
            }
        }
    }








package com.example.monprofil

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage

@Composable
fun SerieScreen(id: String, windowClass: WindowSizeClass, viewModel: MainViewModel,navController: (Any) -> Unit) {

    val serie by viewModel.serie.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) { viewModel.getDetailTv(id) }

    when (windowClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp),
                content = detailSerie(serie, navController)
            )
        }

        else -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp),
                content = detailSerie(serie, navController)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun detailSerie(serie:TmdbTvDetail,navController: (Any) -> Unit): LazyGridScope.() -> Unit = {
    item(span = { GridItemSpan(2) }){
        val affiche = "https://image.tmdb.org/t/p/w780/" + serie.poster_path
        val poster = "https://image.tmdb.org/t/p/w780/" + serie.backdrop_path

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = poster,
                contentDescription = serie.name,
            )

            Text(
                text = serie.name,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(10.dp))
            AsyncImage(
                model = affiche,
                contentDescription = serie.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Synopsys",
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = serie.overview,
                    textAlign = TextAlign.Justify
                )
                Spacer(Modifier.height(15.dp))
                Text(
                    text = "Acteur",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
    items(serie.credits.cast) {credit->
        val imageURL = "https://image.tmdb.org/t/p/w780/" + credit.profile_path
        ElevatedCard(
            onClick = { navController(credit.id) },
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                AsyncImage(
                    model = imageURL,
                    contentDescription = credit.name
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = credit.name,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Spacer(Modifier.height(10.dp))
        }
    }
}

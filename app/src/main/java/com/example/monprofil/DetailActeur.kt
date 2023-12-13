package com.example.monprofil

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
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
fun ActeurScreen(id: String, windowClass: WindowSizeClass, viewModel: MainViewModel) {

    val acteur by viewModel.acteur.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) { viewModel.getDetailActeur(id) }

    when (windowClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp),
                content = detailActeur(acteur)
            )
        }

        else -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp),
                content = detailActeur(acteur)
            )
        }
    }
}

@Composable
private fun detailActeur(acteur:TmdbPersonDetail): LazyGridScope.() -> Unit = {
    item {
        val irl = "https://image.tmdb.org/t/p/w780/" + acteur.profile_path

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = irl,
                contentDescription = acteur.name,
            )

            Text(
                text = acteur.name,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(10.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = acteur.birthday,
                    textAlign = TextAlign.Center,
                )
                Spacer(Modifier.height(15.dp))

                Text(
                    text = acteur.biography,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }}

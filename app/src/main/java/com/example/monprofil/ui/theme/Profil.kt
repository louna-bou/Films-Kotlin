package com.example.monprofil.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.monprofil.R


@Composable
fun Screen(windowClass: WindowSizeClass,onClick: () -> Unit) {

    when (windowClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            Column(Modifier.fillMaxSize(),verticalArrangement = Arrangement.SpaceEvenly,horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(Modifier.height(50.dp))
                MonImage()
                Texte()
                Description()
                Spacer(Modifier.height(55.dp))
                Reseaux()
                Spacer(Modifier.height(180.dp))
                FilledButton(onClick )
            }
        }

        else -> {

            Row(Modifier.fillMaxSize(),verticalAlignment = Alignment.CenterVertically,) {
                Spacer(Modifier.width(20.dp))
                Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {
                    MonImage()
                    Texte()
                    Description()

                }
                Spacer(Modifier.width(30.dp))
                Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {
                    Reseaux()
                    Spacer(Modifier.height(20.dp))
                    FilledButton(onClick )
                }
            }

        }
    }
}


@Composable
fun MonImage(){
    Image(
        painterResource(id = R.drawable.louna),
        contentDescription = "pp louna",
        Modifier
            .size(200.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Black, CircleShape)

    )
}

@Composable
fun Texte() {
    Text(
        text = "Louna Boulade",
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(10.dp)
    )
}
@Composable
fun Description(){
    Text(
        text ="Étudiante en troisième année de BUT MMI, spécialité DEV",
        style = MaterialTheme.typography.bodyMedium
    )
    Text(text ="IUT MMI Castres - Université Paul Sabatier III",
        style = MaterialTheme.typography.bodyMedium)
}
@Composable
fun Reseaux(){
    Column() {
        Row {
            Image(
                painterResource(id = R.drawable.enveloppe),
                contentDescription = "enveloppe",
                Modifier.size(20.dp)
            )
            Spacer(Modifier.width(5.dp))
            Text(text ="louna-bou@orange.fr",
                style = MaterialTheme.typography.bodyMedium)
        }
        Row {
            Image(
                painterResource(id = R.drawable.linkedin),
                contentDescription = "linkedin",
                Modifier.size(20.dp)
            )
            Spacer(Modifier.width(5.dp))
            Text(text ="https://fr.linkedin.com/in/louna-boulade-b8057122a",
                style = MaterialTheme.typography.bodyMedium)
        }
    }

}

@Composable
fun FilledButton(onClick: () -> Unit) {

    Button(onClick = onClick) {
        Text("Démarrer")
    }

}

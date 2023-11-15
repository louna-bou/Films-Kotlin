package com.example.monprofil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.monprofil.ui.theme.MonProfilTheme
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel = MainViewModel()
        setContent {

            MonProfilTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }

            }
            /** NavHost(navController = navController, startDestination = "profile") {
                composable("profile") { Screen(windowSizeClass){ navController.navigate("films") } }
                composable("films") { FilmsScreen() }
            }**/
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            val windowSizeClass = calculateWindowSizeClass(this)
            val destinations = listOf(Destination.Profil, Destination.Films,Destination.Series,Destination.Acteurs)
            Scaffold(
                bottomBar = { BottomNavigation {
                    destinations.forEach { screen ->
                        BottomNavigationItem(
                            icon = { Icon(screen.icon, contentDescription = null) },
                            label = { Text(screen.label) },
                            selected =
                            currentDestination?.hierarchy?.any { it.route == screen.destination } == true,
                            onClick = { navController.navigate(screen.destination) })
                    }}
                }) { innerPadding ->
                NavHost(navController, startDestination = Destination.Profil.destination,
                    Modifier.padding(innerPadding)) {
                    composable(Destination.Profil.destination) { Screen(windowSizeClass){ navController.navigate("films") } }
                    composable(Destination.Films.destination) { FilmsScreen(viewModel) }
                    composable(Destination.Series.destination) { SeriesScreen() }
                    composable(Destination.Acteurs.destination) { ActeursScreen() }
                }
            }

        }
    }}

sealed class Destination(val destination: String, val label: String, val icon: ImageVector) {
    object Profil : Destination("profil", "Profil", Icons.Filled.Person)
    object Films : Destination("films", "Films", Icons.Filled.Home)
    object Series : Destination("series", "Séries", Icons.Filled.Info)
    object Acteurs : Destination("acteurs", "Acteurs", Icons.Filled.Person)
}


@Composable
fun Compteur(viewmodel: MainViewModel) {

    /**Text(text = viewmodel.compteur.toString(),
        modifier = Modifier.clickable {
            viewmodel.incrementer_compteur()
        })**/
}
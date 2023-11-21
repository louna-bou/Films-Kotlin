package com.example.monprofil

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.monprofil.ui.theme.Blue01
import com.example.monprofil.ui.theme.MonProfilTheme

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
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            val windowSizeClass = calculateWindowSizeClass(this)
            val destinations = listOf(
                Destination.Profil,
                Destination.Films,
                Destination.Series,
                Destination.Acteurs
            )
            when (windowSizeClass.widthSizeClass) {
                WindowWidthSizeClass.Compact -> {
                    Menubas(
                        destinations,
                        currentDestination,
                        navController,
                        windowSizeClass,
                        viewModel
                    )

                }

                else -> {
                    Row() {
                        NavigationRail(modifier = Modifier.width(100.dp)) {
                            destinations.forEach { screen ->
                                NavigationRailItem(
                                    icon = { Icon(screen.icon, contentDescription = null) },
                                    label = { Text(screen.label) },
                                    selected = currentDestination?.hierarchy?.any { it.route == screen.destination } == true,
                                    onClick = { navController.navigate(screen.destination) }
                                )
                            }
                        }
                        Menubas(
                            destinations,
                            currentDestination,
                            navController,
                            windowSizeClass,
                            viewModel
                        )
                    }
                }
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
private fun Menubas(
    destinations: List<Destination>,
    currentDestination: NavDestination?,
    navController: NavHostController,
    windowSizeClass: WindowSizeClass,
    viewModel: MainViewModel
) {
    Scaffold(
        bottomBar = {
            if (windowSizeClass.widthSizeClass==WindowWidthSizeClass.Compact)
            BottomNavigation(backgroundColor = Blue01) {
                destinations.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(screen.label) },
                        selected =
                        currentDestination?.hierarchy?.any { it.route == screen.destination } == true,
                        onClick = { navController.navigate(screen.destination) })
                }
            }
        })
    { innerPadding ->
        NavHost(
            navController, startDestination = Destination.Profil.destination,
            Modifier.padding(innerPadding)
        ) {
            composable(Destination.Profil.destination) {
                Screen(windowSizeClass) {
                    navController.navigate(
                        "films"
                    )
                }
            }
            composable(Destination.Films.destination) { FilmsScreen(viewModel,windowSizeClass) }
            composable(Destination.Series.destination) { SeriesScreen() }
            composable(Destination.Acteurs.destination) { ActeursScreen() }
        }
    }
}


sealed class Destination(
    val destination: String,
    val label: String,
    val icon: ImageVector
) {
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
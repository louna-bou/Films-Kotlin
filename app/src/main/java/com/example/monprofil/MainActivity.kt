package com.example.monprofil

import android.os.Bundle
import android.util.EventLogTags.Description
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.monprofil.ui.theme.Films
import com.example.monprofil.ui.theme.MonProfilTheme
import com.example.monprofil.ui.theme.Screen


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            MonProfilTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }

            }
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "profile") {
                composable("profile") { Screen(windowSizeClass){ navController.navigate("films") } }
                composable("films") { Films(windowSizeClass) }
            }
        }
    }}

sealed class Destination(val destination: String, val label: String, val icon: ImageVector) {
    object Profil : Destination("profil", "Mon Profil", Icons.Filled.Person)
    object Edition : Destination("edition", "Edition du profil", Icons.Filled.Edit)
}

@Composable
fun Menu(){
val navController = rememberNavController()
val navBackStackEntry by navController.currentBackStackEntryAsState()
val currentDestination = navBackStackEntry?.destination

val destinations = listOf(Destination.Profil, Destination.Edition)
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
        composable(Destination.Films.destination) { FilmsScreen() }
        composable(Destination.Serie.destination) { SeriesScreen() }
        composable(Destination.Acteur.destination) { ActeursScreen() }
    }
}
}
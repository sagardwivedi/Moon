package com.example.moon.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moon.ui.screens.AstronomyScreen
import com.example.moon.ui.screens.CalendarScreen
import com.example.moon.ui.screens.DetailsScreen
import com.example.moon.ui.screens.HomeScreen
import com.example.moon.ui.screens.ProfileScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        enterTransition = { fadeIn(animationSpec = tween(500)) + slideInHorizontally() },
        exitTransition = { fadeOut(animationSpec = tween(300)) + slideOutHorizontally() },
        popEnterTransition = { fadeIn(animationSpec = tween(500)) + slideInHorizontally() },
        popExitTransition = { fadeOut(animationSpec = tween(300)) + slideOutHorizontally() },
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Calendar.route) { CalendarScreen(navController) }
        composable(Screen.Astronomy.route) { AstronomyScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
        composable(Screen.Details.route) { backStackEntry ->
            val date = backStackEntry.arguments?.getString("date")
            DetailsScreen(date)
        }
    }
}

package com.example.moon.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector


sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Calendar : Screen("calendar", "Calendar", Icons.Default.DateRange)
    object Astronomy : Screen("astronomy", "Astronomy", Icons.Default.Person)
    object Profile : Screen("profile", "Profile", Icons.Default.Person)
    object Details : Screen("details/{date}", "Details", Icons.Default.Info)
}
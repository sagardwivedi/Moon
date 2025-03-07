package com.example.moon.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun AstronomyScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "🔭 Astronomy Data", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Moonrise: 6:45 PM\nMoonset: 5:30 AM")

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate("details/astronomy") }) {
            Text("More Astronomy Info")
        }
    }
}

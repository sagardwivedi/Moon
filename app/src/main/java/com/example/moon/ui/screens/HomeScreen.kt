package com.example.moon.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moon.R
import com.example.moon.ui.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {
    val moonPhase = "Waxing Gibbous"
    val nextFullMoon = "April 20, 2025"
    val moonriseTime = "6:45 PM"
    val moonsetTime = "5:30 AM"

    val scale = remember { Animatable(1f) }

    // Moon animation effect
    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 1.1f,
            animationSpec = infiniteRepeatable(
                animation = tween(2000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "🌙 Moon Tracker",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Animated Moon Icon
        Box(
            modifier = Modifier
                .size(120.dp)
                .scale(scale.value)
                .background(MaterialTheme.colorScheme.surface, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.moon_waxing_gibbous),
                contentDescription = "Current Moon Phase"
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = moonPhase,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Moonrise and Moonset Info
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "🌅 Moonrise", fontSize = 18.sp, fontWeight = FontWeight.Medium)
                Text(text = moonriseTime, fontSize = 16.sp, color = Color.Gray)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "🌄 Moonset", fontSize = 18.sp, fontWeight = FontWeight.Medium)
                Text(text = moonsetTime, fontSize = 16.sp, color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Next Lunar Event
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "🌕 Next Full Moon", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = nextFullMoon, fontSize = 18.sp, color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Quick Navigation Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            QuickActionButton("📅 Calendar", onClick = { navController.navigate(Screen.Calendar.route) })
            QuickActionButton("🔭 Astronomy", onClick = { navController.navigate(Screen.Astronomy.route) })
            QuickActionButton("⚙️ Settings", onClick = { navController.navigate(Screen.Profile.route) })
        }
    }
}

// Quick Action Button Component
@Composable
fun QuickActionButton(text: String, onClick: () -> Unit) {
    ElevatedButton(
        onClick = onClick,
        colors = ButtonDefaults.elevatedButtonColors(containerColor = MaterialTheme.colorScheme.secondary)
    ) {
        Text(text = text, fontSize = 16.sp)
    }
}

package com.example.usertime.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.usertime.NavigationGraph

object Destinations {
    const val HOME_ROUTE = "home"
    const val PROFILE_ROUTE = "profile"
    const val FOLLOWING_ROUTE = "following"
}

@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    NavigationGraph(navController = navController)
}


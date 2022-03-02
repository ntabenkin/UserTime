package com.example.usertime

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.usertime.data.User
import com.example.usertime.ui.Destinations
import com.example.usertime.ui.profile.ProfileScreen

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.HOME_ROUTE,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Destinations.HOME_ROUTE) {
            RecyclerContent(navController)
        }
        composable(Destinations.PROFILE_ROUTE) {
            val person = navController.previousBackStackEntry?.savedStateHandle?.get<User>("user")
            person?.let {
                ProfileScreen(person, navController)
            }
        }
        composable(Destinations.FOLLOWING_ROUTE) {
            FollowingContent(navController)
        }
    }
}
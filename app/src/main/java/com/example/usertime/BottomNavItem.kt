package com.example.usertime

sealed class BottomNavItem(var title: String, var icon: Int, var route: String) {
    object Home : BottomNavItem("Home", R.drawable.ic_home, "home")
    object Profile : BottomNavItem("Profile", R.drawable.ic_profile, "profile")
}
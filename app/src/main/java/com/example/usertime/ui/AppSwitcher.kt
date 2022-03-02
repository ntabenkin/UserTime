package com.example.usertime

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import com.example.usertime.ui.MainScreenView
import com.example.usertime.ui.home.UserState
import com.example.usertime.ui.login.LoginScreen


@ExperimentalFoundationApi
@Composable
fun ApplicationSwitcher() {
    val vm = UserState.current
    if (vm.isLoggedIn) {
        MainScreenView()
    } else {
        LoginScreen()
    }
}
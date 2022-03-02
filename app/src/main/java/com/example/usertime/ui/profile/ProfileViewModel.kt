package com.example.usertime.ui.profile

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.usertime.ui.home.UserStateViewModel
import kotlinx.coroutines.delay

class ProfileViewModel : ViewModel() {
    var isExpanded by mutableStateOf(false)

    suspend fun expanded() {
        isExpanded = true
        delay(20)
    }

    suspend fun closed() {
        isExpanded = false
        delay(20)
    }
}

val ProfileState =
    compositionLocalOf<ProfileViewModel> { error("Profile State Context Not Found!") }


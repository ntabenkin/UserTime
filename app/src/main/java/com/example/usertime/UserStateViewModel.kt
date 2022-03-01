package com.example.usertime

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay


class UserStateViewModel : ViewModel() {
    var isLoggedIn by mutableStateOf(false)
    var isBusy by mutableStateOf(false)

    suspend fun signIn(email: String, password: String) {
        isBusy = true
        delay(2000)
        isLoggedIn = true
        isBusy = false
    }

    suspend fun signOut() {
        isBusy = true
        delay(2000)
        isLoggedIn = false
        isBusy = false
    }

    suspend fun unFollow(user:User){
        isBusy = true
        list.remove(user)
        delay(2000)
        isLoggedIn = true
        isBusy = false
    }
}

val UserState = compositionLocalOf<UserStateViewModel> { error("User State Context Not Found!")
}

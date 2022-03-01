package com.example.usertime

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay


class UserStateViewModel : ViewModel() {
    var isLoggedIn by mutableStateOf(false)
    var loading by mutableStateOf(false)
    var error by mutableStateOf(false)

    suspend fun signIn(email: String, password: String) {
        loading = true
        delay(2000)
        isLoggedIn = true
        loading = false
    }

    suspend fun signOut() {
        loading = true
        delay(2000)
        isLoggedIn = false
        loading = false
    }

    suspend fun unFollow(user:User){
        loading = true
        followingList.remove(user)
        user.followed = false
        delay(20)
        isLoggedIn = true
        loading = false
    }

   suspend fun follow(user:User){
        loading = true
        followingList.add(user)
        user.followed = true
        delay(20)
        isLoggedIn = true
        loading = false
    }
}

val UserState = compositionLocalOf<UserStateViewModel> { error("User State Context Not Found!")
}

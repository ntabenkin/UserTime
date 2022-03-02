package com.example.usertime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.*
import com.example.usertime.ui.home.UserState
import com.example.usertime.ui.home.UserStateViewModel
import com.example.usertime.ui.profile.ProfileState
import com.example.usertime.ui.profile.ProfileViewModel

class MainActivity : ComponentActivity() {
    private val userState by viewModels<UserStateViewModel>()
    private val profileState by viewModels<ProfileViewModel>()
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(UserState provides userState ) {
                CompositionLocalProvider(ProfileState provides profileState) {
                    ApplicationSwitcher()
                }
            }
        }
    }
}
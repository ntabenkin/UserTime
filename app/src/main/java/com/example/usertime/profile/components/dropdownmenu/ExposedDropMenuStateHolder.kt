package com.example.usertime.profile.components.dropdownmenu

import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Size
import com.example.usertime.R

class ExposedDropMenuStateHolder {
    var enabled by mutableStateOf(false)
    var value by mutableStateOf("")
    var selectedIndex by mutableStateOf(-1)
    var size by mutableStateOf(Size.Zero)
    val icon: Int
        @Composable get() = if (enabled) {
            R.drawable.ic_arrow_up
        } else {
            R.drawable.ic_arrow_down
        }
    val items = (1..3).map {
        "Option $it"
    }

    fun onEnabled(newValue: Boolean) {
        enabled = newValue
    }

    fun onSelectedIndex(newValue: Int) {
        selectedIndex = newValue
        value = items[selectedIndex]
    }
}

@Composable
fun rememberExposedMenuStateHolder() = remember {
    ExposedDropMenuStateHolder()
}
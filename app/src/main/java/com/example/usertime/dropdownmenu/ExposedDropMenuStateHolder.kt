package com.example.usertime.dropdownmenu

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
    val items = (1..5).map {
        "option $it"
    }

    fun onEnabled(newValue: Boolean) {
        enabled = newValue
    }

    fun onSelectedIndex(newValue: Int) {
        selectedIndex = newValue
        value = items[selectedIndex]
    }

    fun onSize(newValue: Size) {
        size = newValue
    }

}

@Composable
fun rememberExposedMenuStateHolder() = remember {
    ExposedDropMenuStateHolder()
}
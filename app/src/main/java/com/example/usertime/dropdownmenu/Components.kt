package com.example.usertime.dropdownmenu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

@Composable
fun ProfileDropDown() {
    val stateHolder = rememberExposedMenuStateHolder()
    ExposedDropDownMenu(stateHolder = stateHolder)
}

@Composable
fun ExposedDropDownMenu(stateHolder: ExposedDropMenuStateHolder) {
    Column {
        Box {
            Icon(
                painter = painterResource(id = stateHolder.icon),
                contentDescription = null,
                modifier = Modifier.clickable {
                    stateHolder.onEnabled(!(stateHolder.enabled))
                }
                    .size(30.dp)
            )
               /* modifier = Modifier.onGloballyPositioned {
                    stateHolder.onSize(it.size.toSize())
                }*/

            DropdownMenu(
                expanded = stateHolder.enabled,
                onDismissRequest = {
                    stateHolder.onEnabled(false)
                },
                modifier = Modifier
                    .width(with(LocalDensity.current)
                    { stateHolder.size.width.toDp() })
            ) {
                stateHolder.items.forEachIndexed { index, s ->
                    DropdownMenuItem(
                        onClick = {
                            stateHolder.onSelectedIndex(index)
                            stateHolder.onEnabled(false)
                        }
                    ) {
                        Text(text = s)
                    }
                }
            }
        }
    }
}
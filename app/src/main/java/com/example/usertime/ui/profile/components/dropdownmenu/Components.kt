package com.example.usertime.ui.profile.components.dropdownmenu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ProfileDropDown() {
    val stateHolder = rememberExposedMenuStateHolder()
    ExposedDropDownMenu(stateHolder = stateHolder)
}

@Composable
fun ExposedDropDownMenu(stateHolder: ExposedDropMenuStateHolder) {
    Column {
        Box {
            Modifier.wrapContentSize(Alignment.TopEnd)
            Icon(
                painter = painterResource(id = stateHolder.icon),
                contentDescription = null,
                modifier = Modifier
                    .clickable { stateHolder.onEnabled(!(stateHolder.enabled)) }
                    .size(30.dp)
            )

            DropdownMenu(
                expanded = stateHolder.enabled,
                onDismissRequest = {
                    stateHolder.onEnabled(false)
                },
                modifier = Modifier.wrapContentSize(Alignment.TopEnd)
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
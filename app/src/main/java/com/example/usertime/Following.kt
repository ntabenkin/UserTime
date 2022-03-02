package com.example.usertime

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.usertime.common.DefaultToolBar
import com.example.usertime.common.PostImage
import com.example.usertime.data.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun FollowingContent(navController: NavController) {
    val vm = UserState.current
    val coroutineScope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxSize()) {
        DefaultToolBar(user = "Team Members Following", navController)
        FollowingHomeContent(navController, vm, coroutineScope)
    }
}

@Composable
fun FollowingHomeContent(
    navController: NavController,
    vm: UserStateViewModel,
    coroutineScope: CoroutineScope
) {
    if (vm.loading) {
        CircularProgressIndicator()
    } else {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                items = followingList,
                itemContent = {
                    FollowingListItem(user = it, navController = navController,vm,coroutineScope)
                })
        }
    }
}

@Composable
fun FollowingListItem(
    user: User,
    navController: NavController,
    vm: UserStateViewModel,
    coroutineScope: CoroutineScope
) {
    val selected = remember { mutableStateOf(true) }
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set("user", user)
                navController.navigate("profile")
            },
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
            Row(
                modifier = Modifier
                    .padding(4.dp)
            ) {
                Text(text = user.name, style = MaterialTheme.typography.h6, color = Color.Black)
            }
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .fillMaxSize()
            ) {
                PostImage(user)
                Text(text = user.profile_description, style = MaterialTheme.typography.caption)
                Text(text = user.url, style = MaterialTheme.typography.caption)
                Text(text = user.profile_name, style = MaterialTheme.typography.caption)

                Button(
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (selected.value) Color.Transparent else Color.Transparent
                    ),
                    onClick = {
                    coroutineScope.launch {
                        vm.unFollow(user)
                    }
                    },
                    // Uses ButtonDefaults.ContentPadding by default
                    contentPadding = PaddingValues(
                        start = 2.dp,
                        top = 10.dp,
                        end = 25.dp,
                        bottom = 10.dp
                    )
                ) {
                    // Inner content including an icon and a text label
                    Icon(
                        if (selected.value) Icons.Filled.Favorite else Icons.Outlined.Favorite,
                        contentDescription = "Favorite",
                        tint = if (selected.value) Color.Black else Color.White,
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    if (!selected.value) {
                        Text("Follow")
                    } else {
                        Text("UnFollow")
                    }
                }
            }
        }
    }


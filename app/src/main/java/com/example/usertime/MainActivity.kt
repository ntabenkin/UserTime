package com.example.usertime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val userState by viewModels<UserStateViewModel>()

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(UserState provides userState) {
                ApplicationSwitcher()
            }
        }
    }
}

@Composable
 fun PostImage(post: User) {
    Image(
        painter = painterResource(id = post.avatar),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .padding(top = 40.dp)
            .size(300.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}

@Composable
fun PostHomeContent(navController: NavController) {
    val user = remember { DataProvider.userList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = user,
            itemContent = {
                PostListItem(user = it, navController = navController)
            })
    }
}

@Composable
fun RecyclerContent(navController: NavController) {
    val vm = UserState.current
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Android Team")
                },
                actions = {
                    IconButton(onClick = {
                        coroutineScope.launch {
                            vm.signOut()
                        }
                    }) {
                        Icon(Icons.Filled.ExitToApp, null)
                    }
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 10.dp
            )
        }, content = {
            PostHomeContent(navController)
        })
}

var list = arrayListOf<User>()
@Composable
fun PostListItem(user: User, navController: NavController) {
    val selected = remember { mutableStateOf(false) }
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
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (selected.value) Color.Transparent else Color.Transparent
                ),
                onClick = { selected.value = !selected.value; list.add(user)},
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
                if (!selected.value){
                    Text("Like")
                } else {
                    Text("")
                }
            }
        }
    }
}


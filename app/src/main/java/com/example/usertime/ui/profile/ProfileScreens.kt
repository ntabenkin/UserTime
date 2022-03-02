package com.example.usertime.ui.profile

import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.usertime.data.DataProvider
import com.example.usertime.ui.common.ImageWithText
import com.example.usertime.R
import com.example.usertime.data.User
import com.example.usertime.ui.common.DefaultToolBar
import com.example.usertime.ui.profile.components.*
import kotlinx.coroutines.launch


@Composable
fun ProfileScreen(user: User, navController: NavController) {
    var selectedTabIntex by remember {
        mutableStateOf(0)
    }
    val vm = ProfileState.current
    val coroutineScope = rememberCoroutineScope()
    if (!vm.isExpanded) {
        Column(modifier = Modifier.fillMaxSize()) {

            DefaultToolBar(user.name, navController)
            Spacer(modifier = Modifier.height(15.dp))

            ProfileSection(user, navController)

            ProfileDescription(
                displayName = user.profile_name,
                description = user.profile_description,
                url = user.url,
                followedBy = user.followers,
                otherCount = 18
            )
            Spacer(modifier = Modifier.height(10.dp))

            HighlightSection(
                highlights = listOf(
                    ImageWithText(
                        image = painterResource(id = user.avatar),
                        text = "My Highlights"
                    )
                )
            )
            Spacer(modifier = Modifier.height(10.dp))

            PostTabView(
                imageWithText = listOf(
                    ImageWithText(
                        image = painterResource(id = R.drawable.ic_grid),
                        text = "Posts"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.ic_reels),
                        text = "Reels"
                    )
                )
            ) {
                selectedTabIntex = it
            }
            when (selectedTabIntex) {
                0 -> PostSection(
                    posts = listOf(
                        painterResource(id = user.posts[0].img),
                        painterResource(id = user.posts[1].img),
                        painterResource(id = user.posts[2].img),
                        painterResource(id = user.posts[3].img)
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                1 -> PostSection(
                    posts = listOf(
                        painterResource(id = user.posts[4].img),
                        painterResource(id = user.posts[5].img),
                        painterResource(id = user.posts[6].img),
                        painterResource(id = user.posts[0].img)
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                2 -> PostSection(
                    posts = listOf(
                        painterResource(id = user.posts[1].img),
                        painterResource(id = user.posts[2].img),
                        painterResource(id = user.posts[3].img),
                        painterResource(id = user.posts[4].img)
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }else {
        Image(
            painter = painterResource(id = user.avatar),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
                .fillMaxHeight()
                .fillMaxWidth()
                .size(400.dp)
                .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                .clickable {
                    coroutineScope.launch {
                        vm.closed()
                    }}
        )

    }
}

@Composable
@Preview(showSystemUi = true)
fun ProfilePagePreview() {
    ProfileScreen(
        user = DataProvider.userList[0],
        navController = rememberNavController()
    )
}


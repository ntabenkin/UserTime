package com.example.usertime.profile

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.usertime.data.DataProvider
import com.example.usertime.common.ImageWithText
import com.example.usertime.R
import com.example.usertime.data.User
import com.example.usertime.common.DefaultToolBar
import com.example.usertime.profile.components.*


@Composable
fun ProfileScreen(user: User, navController: NavController) {
    var selectedTabIntex by remember {
        mutableStateOf(0)
    }
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
}

@Composable
@Preview(showSystemUi = true)
fun ProfilePagePreview() {
    ProfileScreen(
        user = DataProvider.userList[0],
        navController = rememberNavController()
    )
}


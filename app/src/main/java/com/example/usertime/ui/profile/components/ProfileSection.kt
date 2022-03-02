package com.example.usertime.ui.profile.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.usertime.*
import com.example.usertime.ui.common.RoundImage
import com.example.usertime.data.User

@Composable
fun ProfileSection(user: User, navController: NavController) {
    Column(Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = painterResource(id = user.avatar),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f), user, navController)
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun StatSection(modifier: Modifier = Modifier, user: User, navController: NavController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(navController, numberText = user.posts.size.toString(), text = "Posts")
        ProfileStat(navController, numberText = user.followers.size.toString(), text = "Followers")
        ProfileStat(navController, numberText = followingList.size.toString(), text = "Following")
    }
}

@Composable
fun ProfileStat(
    navController: NavController,
    numberText: String,
    text: String,
    modifier: Modifier = Modifier

) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable { navController.navigate("following") } // navigate to followers
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

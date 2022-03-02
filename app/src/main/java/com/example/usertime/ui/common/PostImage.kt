package com.example.usertime.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.usertime.data.Posts
import com.example.usertime.data.User

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
fun FullScreenImage(post: User) {
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
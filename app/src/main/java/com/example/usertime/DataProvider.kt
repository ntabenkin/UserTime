package com.example.usertime

object DataProvider {
    val postList = listOf(
        Posts(
            userId = 1,
            img = R.drawable.andres_avatar,
            date = "02/04/2022",
            description = "Wai"
        ),Posts(
            userId = 2,
            img = R.drawable.diego_avatar,
            date = "02/04/2022",
            description = "I really like tea"
        ),Posts(
            userId = 3,
            img = R.drawable.nico_avatar,
            date = "02/04/2022",
            description = "Did someone say extra time in my day "
        ),Posts(
            userId = 4,
            img = R.drawable.matias_avatar,
            date = "02/04/2022",
            description = "Heading in time something is basic description"
        ),Posts(
            userId = 5,
            img = R.drawable.juan_avatar,
            date = "02/04/2022",
            description = "Heading in time something is basic description"
        ),Posts(
            userId = 6,
            img = R.drawable.matt_avatar,
            date = "02/04/2022",
            description = "Heading in time something is basic description"
        ),Posts(
            userId = 7,
            img = R.drawable.nate_avatar,
            date = "02/04/2022",
            description = "Heading in time something is basic description"
        )
    )
    val followersList = listOf( "ntabenkin", "mmurphy34", "aoller44")
    val userList = listOf(
        User(
            id = 1,
            name = "Nathan",
            profile_name= "ntabenkin",
            dob = "07/17/1997",
            avatar = R.drawable.nate_avatar,
            posts = postList,
            followers = followersList,
            url = "www.facebook.com",
            profile_description = "My Names Nathan"
        ),User(
            id = 2,
            name = "Mathew",
            profile_name= "mmurphy34",
            dob = "07/17/1997",
            avatar = R.drawable.matt_avatar,
            posts = postList,
            followers = followersList,
            url = "www.facebook.com",
            profile_description = "My names Mathew "
        ),User(
            id = 3,
            name = "Nico",
            profile_name= "nicoswavay33",
            dob = "07/17/1997",
            avatar = R.drawable.nico_avatar,
            posts = postList,
            followers = followersList,
            url = "www.facebook.com",
            profile_description = "My names Nico"
        ),User(
            id = 4,
            name = "Diego",
            profile_name= "dbunz444",
            dob = "07/17/1997",
            avatar = R.drawable.diego_avatar,
            posts = postList,
            followers = followersList,
            url = "www.facebook.com",
            profile_description = "My Names Diego"
        ),User(
            id = 5,
            name = "Matias",
            profile_name= "mtais44",
            dob = "07/17/1997",
            avatar = R.drawable.andres_avatar,
            posts = postList,
            followers = followersList,
            url = "www.facebook.com",
            profile_description = "I like apples"
        )
    )
}
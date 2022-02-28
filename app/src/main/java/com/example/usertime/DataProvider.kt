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
    val followingList = listOf( "ntabenkin", "mmurphy34", "aoller44","ntabenkin", "mmurphy34", "aoller44")
    val userList = listOf(
        User(
            id = 1,
            name = "Nathan Tabenkin",
            profile_name= "ntabenkin",
            dob = "07/17/1997",
            avatar = R.drawable.nate_avatar,
            posts = postList,
            followers = followersList,
            following = followingList,
            url = "ntabenkin@ovloop.com",
            profile_description = "My Names Nathan"
        ),User(
            id = 2,
            name = "Matthew Murphy",
            profile_name= "mmurphy34",
            dob = "07/17/1997",
            avatar = R.drawable.matt_avatar,
            posts = postList,
            followers = followersList,
            following = followingList,
            url = "mmurphy@ovloop.com",
            profile_description = "Android Engineer"
        ),User(
            id = 3,
            name = "Nicolas Calderini",
            profile_name= "nicoswavay33",
            dob = "07/17/1997",
            avatar = R.drawable.nico_avatar,
            posts = postList,
            followers = followersList,
            following = followingList,
            url = "ncalderini@ovloop.com",
            profile_description = "Alternate Team Lead - Android Engineer"
        ),User(
            id = 4,
            name = "Diego Iribarne",
            profile_name= "dbunz444",
            dob = "07/17/1997",
            avatar = R.drawable.diego_avatar,
            posts = postList,
            followers = followersList,
            following = followingList,
            url = "ncalderini@ovloop.com",
            profile_description = "Android Engineer"
        ),User(
            id = 5,
            name = "Andres Oller",
            profile_name= "aoler44",
            dob = "07/17/1997",
            avatar = R.drawable.andres_avatar,
            posts = postList,
            followers = followersList,
            following = followingList,
            url = "aoller@ovloop.com",
            profile_description = "Team Lead - Android Engineer"
        ),User(
            id = 6,
            name = "Matias Cestoni",
            profile_name= "mtais44",
            dob = "07/17/1997",
            avatar = R.drawable.matias_avatar,
            posts = postList,
            followers = followersList,
            following = followingList,
            url = "mcestoni@ovloop.com",
            profile_description = "Android Engineer"
        )
        ,User(
            id = 7,
            name = "Juan Guerrero",
            profile_name= "jguer55",
            dob = "07/17/1997",
            avatar = R.drawable.juan_avatar,
            posts = postList,
            followers = followersList,
            following = followingList,
            url = "jguerrero@ovloop.com",
            profile_description = "Android Engineer"
        )
    )
}
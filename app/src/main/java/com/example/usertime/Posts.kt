package com.example.usertime

data class Posts(
    val userId: Int,
    val img: Int = 0,
    val date: String,
    val description: String
)
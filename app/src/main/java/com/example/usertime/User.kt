package com.example.usertime


data class User(
    val id: Int,
    val name: String,
    val dob: String,
    val avatar: Int = 0,
    val posts: List<Posts>
)
package com.example.usertime

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Int,
    val name: String,
    val profile_name: String,
    val dob: String,
    val avatar: Int = 0,
    val posts: List<Posts>,
    val followers: List<String>,
    val following: List<String>,
    val url: String,
    val profile_description: String,

) : Parcelable

package com.example.usertime.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Posts(
    val userId: Int,
    val img: Int = 0,
    val date: String,
    val description: String
) : Parcelable
package com.example.neighbuddy.domain.users

import com.google.gson.annotations.SerializedName

data class Notification(
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("title")
    val title: String,
    @field:SerializedName("description")
    val description: String,
    @field:SerializedName("date")
    val date: String,
)
package com.example.neighbuddy.domain.users

import com.google.gson.annotations.SerializedName

data class Alert(
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("title")
    val title: String,
    @field:SerializedName("description")
    val description: String,
    @field:SerializedName("date")
    val date: String,
    @field:SerializedName("latitude")
    val latitude: String,
    @field:SerializedName("longitude")
    val longitude: String,
)
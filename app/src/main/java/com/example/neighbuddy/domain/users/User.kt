package com.example.neighbuddy.domain.users

import com.google.gson.annotations.SerializedName

data class User(
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("email")
    val email: String,
    @field:SerializedName("password")
    val password: String,
    @field:SerializedName("alerts")
    val alerts: List<Alert>,
    @field:SerializedName("notifications")
    val notifications: List<Notification>,
)
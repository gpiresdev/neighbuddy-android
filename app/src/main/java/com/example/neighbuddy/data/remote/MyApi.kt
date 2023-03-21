package com.example.neighbuddy.data.remote

import com.example.neighbuddy.domain.users.User
import com.example.neighbuddy.resources.NetworkResult
import retrofit2.http.GET

interface MyApi {
    @GET("/users/{id}")
    suspend fun getUserById(id: Int):NetworkResult<User>
}
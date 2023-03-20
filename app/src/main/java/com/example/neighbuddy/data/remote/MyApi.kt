package com.example.neighbuddy.data.remote

import retrofit2.http.GET

interface MyApi {
    @GET("api")
    suspend fun doNetworkCall()
}
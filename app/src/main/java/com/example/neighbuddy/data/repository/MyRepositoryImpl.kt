package com.example.neighbuddy.data.repository

import android.app.Application
import android.net.Network
import android.util.Log
import com.example.neighbuddy.R
import com.example.neighbuddy.data.remote.MyApi
import com.example.neighbuddy.domain.repository.MyRepository
import com.example.neighbuddy.domain.users.User
import com.example.neighbuddy.resources.NetworkResult
import retrofit2.Response

class MyRepositoryImpl(
    private val api: MyApi,
    private val appContext: Application
): MyRepository {

    init {
        val appName = appContext.getString(R.string.app_name)
        Log.i("MyRepositoryImpl", appName)
        println("MyRepositoryImpl: $appName")
    }
    override suspend fun getUserById(id: Int): NetworkResult<User> = api.getUserById(1)
}
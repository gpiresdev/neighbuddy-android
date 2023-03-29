package com.example.neighbuddy.data.repository

import android.app.Application
import android.util.Log
import com.example.neighbuddy.R
import com.example.neighbuddy.data.remote.MyApi
import com.example.neighbuddy.domain.repository.MyRepository

class MyRepositoryImpl(
    private val api: MyApi,
    private val appContext: Application
): MyRepository {

    init {
        val appName = appContext.getString(R.string.app_name)
        Log.i("MyRepositoryImpl", appName)
        println("MyRepositoryImpl: $appName")
    }
    override suspend fun doNetworkCall() {
        TODO("Not yet implemented")
    }
}
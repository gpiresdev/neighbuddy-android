package com.example.neighbuddy.domain.repository

interface MyRepository {
    suspend fun doNetworkCall()
}
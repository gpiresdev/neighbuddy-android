package com.example.neighbuddy.domain.repository

import com.example.neighbuddy.domain.users.User
import com.example.neighbuddy.resources.NetworkResult

interface MyRepository {
    suspend fun getUserById(id: Int): NetworkResult<User>
}
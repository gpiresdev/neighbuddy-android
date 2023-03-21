package com.example.neighbuddy.components

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neighbuddy.domain.repository.MyRepository
import com.example.neighbuddy.domain.users.User
import com.example.neighbuddy.resources.NetworkResult
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val myRepository: MyRepository
):ViewModel(){

    init {
        getUsers()
    }

    val snapshotStateList = SnapshotStateList<User>()

    private fun getUsers() = viewModelScope.launch {
        when (val result = myRepository.getUserById(1)) {
            is NetworkResult.Success -> {
                result.data?.let { snapshotStateList.addAll(it) }
            }
            else -> {

            }
        }

    }}
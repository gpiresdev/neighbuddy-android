package com.example.neighbuddy.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.neighbuddy.LoginForm
import com.example.neighbuddy.navigation.Graph

@Composable
fun Login(navController: NavController) {
    val (name, setName) = rememberSaveable { mutableStateOf("") }
    val (password, setPassword) = rememberSaveable { mutableStateOf("") }
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column() {
            LoginForm(name, password, onNameChange = setName, onPasswordChange = setPassword, onLogin = {
                navController.navigate(Graph.MAIN)
            })
        }
    }
}

sealed class LoginScreen(val route: String) {
    object Login: LoginScreen(route = "login")
}
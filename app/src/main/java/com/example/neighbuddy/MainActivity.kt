package com.example.neighbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.neighbuddy.screen.Dashboard
import com.example.neighbuddy.screen.Login
import com.example.neighbuddy.ui.theme.NeighBuddyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NeighBuddyTheme {
                // create a nav controller
                val navController = rememberNavController()
                // create a route for the login screen
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        Login(
                            navController = navController
                        )
                    }
                    composable("dashboard") {
                        Dashboard()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NeighBuddyTheme {
        LoginForm("", "", onNameChange = {}, onPasswordChange = {}, onLogin = {})
    }
}
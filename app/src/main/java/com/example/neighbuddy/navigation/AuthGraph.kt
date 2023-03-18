package com.example.neighbuddy.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.neighbuddy.screen.Login


fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = "login"
    ) {
        composable(route = "login") {
            Login(navController = navController)
        }
    }
}
package com.example.neighbuddy.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.neighbuddy.components.MapState
import com.example.neighbuddy.screen.DashboardScreen

@ExperimentalMaterial3Api
@Composable
fun RootNavigationGraph(navHostController: NavHostController, mapState: MapState) {

    NavHost(navController = navHostController,startDestination = Graph.AUTH, route = Graph.ROOT) {
        authNavGraph(navHostController)
        composable(route = Graph.MAIN) {
            DashboardScreen(navController = navHostController, mapState = mapState)
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTH = "auth_graph"
    const val MAIN = "main_graph"
}
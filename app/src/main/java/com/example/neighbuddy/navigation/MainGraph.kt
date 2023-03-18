package com.example.neighbuddy.navigation

import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.neighbuddy.components.MapState
import com.example.neighbuddy.screen.Dashboard
import com.example.neighbuddy.screen.NotificationsScreen
import com.example.neighbuddy.screen.ReservationsScreen

@ExperimentalMaterial3Api
@Composable
fun MainGraph(navController: NavHostController, mapState: MapState) {

    NavHost(navController = navController, route = Graph.MAIN, startDestination = "dashboard") {
        composable(route = "dashboard") {
            Dashboard(state = mapState)
        }
        composable(route = "notifications") {
            NotificationsScreen()
        }
        composable(route = "reservations") {
            ReservationsScreen()
        }
    }
}

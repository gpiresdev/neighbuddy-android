package com.example.neighbuddy.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.neighbuddy.components.MapState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun DashboardScreen(navController: NavHostController, mapState: MapState) {
    Scaffold(
        bottomBar = {
            BottomAppBar() {
                Row() {
                    NavigationBarItem(
                        selected = true,
                        onClick = {navController.navigate("dashboard")},
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home") }
                    )

                    NavigationBarItem(
                        selected = false,
                        onClick = {navController.navigate("notifications")},
                        icon = { Icon(Icons.Default.Notifications, contentDescription = "Notificações") }
                    )

                    NavigationBarItem(
                        selected = false,
                        onClick = {navController.navigate("bookings")},
                        icon = { Icon(Icons.Default.EventNote, contentDescription = "Reservas") }
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }, ) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar alerta")
            }
        },
        content = {
            Dashboard(state = mapState)
        }
    )
}
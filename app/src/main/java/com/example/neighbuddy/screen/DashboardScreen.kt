package com.example.neighbuddy.screen

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable


import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.neighbuddy.components.MapState
import com.example.neighbuddy.navigation.MainGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun DashboardScreen(navController: NavHostController, mapState: MapState) {
    Scaffold(
        bottomBar = {
            BottomAppBar() {
                Button(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Home, contentDescription = "Home")
                };
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Notifications, contentDescription = "Notificacoes")
                };
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.EventNote, contentDescription = "Reservas")
                };
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }, ) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar alerta")
            }
        },
        content = {
            MainGraph(navController = navController, mapState = mapState)
        }
    )
}
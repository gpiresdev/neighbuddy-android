package com.example.neighbuddy.screen

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.EventNote
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun BookingScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomAppBar() {
                Row() {
                    NavigationBarItem(
                        selected = false,
                        onClick = {navController.navigate("dashboard")},
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home") }
                    )

                    NavigationBarItem(
                        selected = false,
                        onClick = {navController.navigate("notifications")},
                        icon = { Icon(Icons.Default.Notifications, contentDescription = "Notificações") }
                    )

                    NavigationBarItem(
                        selected = true,
                        onClick = {},
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
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
                Text(text = "Reservas", style = MaterialTheme.typography.headlineMedium)
            }
        }
    )
}
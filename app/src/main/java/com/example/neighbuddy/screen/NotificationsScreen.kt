package com.example.neighbuddy.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.EventNote
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.neighbuddy.components.Notification
import com.example.neighbuddy.domain.users.User

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun NotificationsScreen(navController : NavHostController) {
    val rememberScrollState = rememberScrollState();
    Scaffold(
        bottomBar = {
            BottomAppBar() {
                Row() {
                    NavigationBarItem(
                        selected = false,
                        onClick = { navController.navigate("dashboard") },
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home") }
                    )

                    NavigationBarItem(
                        selected = true,
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
            FloatingActionButton(onClick = { /*TODO*/ }, shape = MaterialTheme.shapes.extraLarge) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar alerta")
            }
        },
        content = {
            Row(modifier = Modifier
                .padding(16.dp, 32.dp)
                .fillMaxWidth()
            ) {
                Column(modifier = Modifier.verticalScroll(rememberScrollState, true)) {
                    Notification(title = "Encomenda entregue", description = "Nova encomenda entregue na portaria.", date = "30/02/2023")
                    Notification(title = "Encomenda entregue", description = "Nova encomenda entregue na portaria.", date = "01/03/2023")
                    Notification(title = "Nova reserva", description = "Reserva de Quadra de esportes efetuada.", date = "21/03/2023")
                }

            }
        }
    )
}
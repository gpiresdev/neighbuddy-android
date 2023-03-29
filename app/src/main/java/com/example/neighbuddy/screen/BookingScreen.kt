package com.example.neighbuddy.screen

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.util.Log
import com.marosseleng.compose.material3.datetimepickers.date.ui.dialog.DatePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import com.example.neighbuddy.components.SelectInput
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import com.marosseleng.compose.material3.datetimepickers.date.domain.DatePickerDefaults
import com.marosseleng.compose.material3.datetimepickers.date.domain.DatePickerTypography
import java.time.LocalDate


@OptIn(ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun BookingScreen(navController: NavHostController) {
    // items do input do select
    val options = listOf("Quadra de Futebol", "Salão de Festas", "Quiosque")

    val openDialog = remember { mutableStateOf(false) }


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
                .padding(16.dp)
            ) {
                Text(text = "Reservas", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(0.dp, 16.dp))
                Row() {
                    Column() {
                        SelectInput(options = options)
                    }

                    // select

                    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom) {
                        IconButton(onClick = { openDialog.value = true }) {
                            Icon(Icons.Default.CalendarMonth, contentDescription = "Nova reserva", Modifier.size(48.dp))
                        }
                    }

                    if (openDialog.value) {
                        DatePickerDialog(
                            onDismissRequest = { openDialog.value = false },
                            onDateChange = { date -> { Log.d("DATE", date.toString()) } },
                        )
                    }

                }
            }
        }
    )
}
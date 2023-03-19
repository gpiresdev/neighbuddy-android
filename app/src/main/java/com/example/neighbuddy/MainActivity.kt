package com.example.neighbuddy

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import com.example.neighbuddy.ui.theme.NeighBuddyTheme
import com.google.android.gms.location.FusedLocationProviderClient
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.neighbuddy.components.MapViewModel
import com.example.neighbuddy.screen.BookingScreen
import com.example.neighbuddy.screen.DashboardScreen
import com.example.neighbuddy.screen.Login
import com.example.neighbuddy.screen.NotificationsScreen
import com.google.android.gms.location.LocationServices
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val viewModel: MapViewModel by viewModels()

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                viewModel.getDeviceLocation(fusedLocationClient)
            }
        }

    private fun askPermissions() = when {
        ContextCompat.checkSelfPermission(
            this,
            ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED -> {
            viewModel.getDeviceLocation(fusedLocationClient)
        }
        else -> {
            requestPermissionLauncher.launch(ACCESS_FINE_LOCATION)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NeighBuddyTheme {
                fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
                askPermissions()
                // create a nav controller
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login") {
                    composable(route = "login") {
                        Login(navController = navController)
                    }
                    composable(route = "dashboard") {
                        DashboardScreen(navController = navController, mapState = viewModel.state.value)
                    }
                    composable(route = "notifications") {
                        NotificationsScreen(navController = navController)
                    }
                    composable(route = "bookings") {
                        BookingScreen(navController = navController)
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
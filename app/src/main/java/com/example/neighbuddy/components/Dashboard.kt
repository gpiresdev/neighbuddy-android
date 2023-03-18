package com.example.neighbuddy.screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.example.neighbuddy.components.MapState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun Dashboard(state: MapState) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Map(state)
    }
}

@Composable
fun Map(state: MapState) {
    //create a markers state
    // Set properties using MapProperties which you can use to recompose the map
    Log.i("DashboardMap", "Location: ${state.lastKnownLocation}")
    var (mapProperties, setMapProperties) = remember {
        mutableStateOf(
            MapProperties(
                maxZoomPreference = 60f,
                minZoomPreference = 16f,
                isMyLocationEnabled = state.lastKnownLocation != null,
                mapType = MapType.SATELLITE
            )
        )
    }

    // Set UI settings using MapUiSettings which you can use to recompose the map
    var (mapUiSettings, setMapUiSettings) = remember {
        mutableStateOf(
            MapUiSettings(
                zoomControlsEnabled = false,
                mapToolbarEnabled = false,
                compassEnabled = false,
            )
        )
    }

    // Set camera position using CameraPositionState which you can use to recompose the map
    val cameraPositionState = rememberCameraPositionState{
        val latLng = LatLng(state.lastKnownLocation!!.latitude, state.lastKnownLocation!!.longitude)
        position = CameraPosition.fromLatLngZoom(latLng, 10f)
    }

    Box(Modifier.fillMaxSize()) {
        GoogleMap(
            properties = mapProperties,
            uiSettings = mapUiSettings,
            cameraPositionState = cameraPositionState,
        ) {
            Marker(
                state = MarkerState(position = LatLng(-20.823142, -49.484232)),
                title = "Alerta",
                snippet = "Crianças brincando na rua"
            )
            Marker(
                state = MarkerState(position = LatLng(-20.821686, -49.483480)),
                title = "Alerta",
                snippet = "Eu sou sinistro"
            )
        }
    }
}
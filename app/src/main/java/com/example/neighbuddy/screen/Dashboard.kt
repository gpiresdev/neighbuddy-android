package com.example.neighbuddy.screen

import android.location.Location
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.neighbuddy.MapState
import com.google.android.gms.maps.CameraUpdateFactory
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
    // Set properties using MapProperties which you can use to recompose the map
    Log.i("DashboardMap", "Location: ${state.lastKnownLocation}")
    var (mapProperties, setMapProperties) = remember {
        mutableStateOf(
            MapProperties(
                maxZoomPreference = 60f,
                minZoomPreference = 16f,
                isMyLocationEnabled = state.lastKnownLocation != null,
            )
        )
    }
    var (mapUiSettings, setMapUiSettings) = remember {
        mutableStateOf(
            MapUiSettings(mapToolbarEnabled = false)
        )
    }

    val cameraPositionState = rememberCameraPositionState{
        val latLng = LatLng(state.lastKnownLocation!!.latitude, state.lastKnownLocation!!.longitude)
        position = CameraPosition.fromLatLngZoom(latLng, 10f)
    }

    Box(Modifier.fillMaxSize()) {
        GoogleMap(
            properties = mapProperties,
            uiSettings = mapUiSettings,
            cameraPositionState = cameraPositionState,
        )
    }
}
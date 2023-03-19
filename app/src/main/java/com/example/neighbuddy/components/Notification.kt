package com.example.neighbuddy.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.Date

@Composable
fun Notification(title: String, description: String, date: String) {
    Column() {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(text = date, style = MaterialTheme.typography.bodySmall)

        Divider(
            modifier = Modifier.padding(0.dp, 16.dp),
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.12f),
            thickness = 1.dp
        )
    }
}
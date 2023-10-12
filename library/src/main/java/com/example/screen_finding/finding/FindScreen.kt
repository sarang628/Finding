package com.example.screen_finding.finding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.screen_map.MapScreen
import com.example.screen_map.MapViewModel
import com.sryang.screen_filter.ui.Filter

@Composable
fun FindScreen(
    restaurantCardPage: @Composable () -> Unit,
    mapScreen: @Composable () -> Unit,
    filter: @Composable () -> Unit,
    onZoomIn: () -> Unit,
    onZoomOut: () -> Unit,
    myLocation: @Composable () -> Unit,
) {
    Box {
        mapScreen.invoke()
        Column {
            filter.invoke()
            Column(
                Modifier.weight(1f),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End
            ) {
                Row(Modifier.padding(end = 8.dp)) {
                    Button(onClick = { onZoomIn.invoke() }) {
                        Text(text = "+")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = { onZoomOut.invoke() }) {
                        Text(text = "-")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    myLocation.invoke()
                }
                restaurantCardPage()
            }
        }
    }
}
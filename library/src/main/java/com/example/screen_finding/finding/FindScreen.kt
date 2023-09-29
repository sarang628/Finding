package com.example.screen_finding.finding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.screen_map.MapScreen
import com.example.screen_map.MapViewModel
import com.sryang.screen_filter.ui.Filter

@Composable
fun FindScreen(
    restaurantCardPage: @Composable () -> Unit,
    mapScreen: @Composable () -> Unit
) {
    Box {
        mapScreen.invoke()
        Column {
            Filter()
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.Bottom) {
                restaurantCardPage()
            }
        }
    }
}
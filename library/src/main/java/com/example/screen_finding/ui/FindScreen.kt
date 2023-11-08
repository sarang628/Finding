package com.example.screen_finding.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FindScreen(
    onZoomIn: () -> Unit,
    onZoomOut: () -> Unit,
    restaurantCardPage: @Composable () -> Unit,
    mapScreen: @Composable () -> Unit,
    filter: @Composable () -> Unit,
    myLocation: @Composable () -> Unit,
) {
    Box {
        mapScreen.invoke() // 지도화면
        filter.invoke() // 필터화면
        Column(
            Modifier.align(Alignment.BottomEnd),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            // 지도 확대, 축소, 내위치 버튼
            Buttons(onZoomIn = onZoomIn, onZoomOut = onZoomOut, myLocation = myLocation)
            restaurantCardPage.invoke() // 카드 페이지
        }
    }
}

@Composable
fun Buttons(
    onZoomIn: () -> Unit,
    onZoomOut: () -> Unit,
    myLocation: @Composable () -> Unit,
) {
    Row(
        Modifier
            .padding(end = 8.dp)
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.weight(1f))
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
}
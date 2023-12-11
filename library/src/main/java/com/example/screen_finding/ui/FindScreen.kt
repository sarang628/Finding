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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.logging.ErrorManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindScreen(
    errorMessage: String? = null,
    consumeErrorMessage : (()->Unit)? = null,
    onZoomIn: () -> Unit,
    onZoomOut: () -> Unit,
    restaurantCardPage: @Composable () -> Unit,
    mapScreen: @Composable () -> Unit,
    filter: @Composable () -> Unit,
    myLocation: @Composable () -> Unit,
) {
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = errorMessage, block = {
        errorMessage?.let {
            snackbarHostState.showSnackbar(it, duration = SnackbarDuration.Short)
            consumeErrorMessage?.invoke()
        }
    })

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {
        Box(Modifier.padding(it)) {
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
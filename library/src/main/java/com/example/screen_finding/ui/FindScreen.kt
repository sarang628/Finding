package com.example.screen_finding.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @param onZoomIn 줌인 클릭
 * @param onZoomOut 줌아웃 클릭
 * @param restaurantCardPage 음식점 카드 페이지
 * @param mapScreen 맵
 * @param filter 필터
 * @param myLocation 내 위치 버튼
 * @param buttonBottomPadding 하단 패딩
 * @param onMyLocation 내 위치 클릭
 */
@Composable
fun FindScreen(onZoomIn: () -> Unit, onZoomOut: () -> Unit, restaurantCardPage: @Composable () -> Unit, mapScreen: @Composable () -> Unit, filter: @Composable () -> Unit, buttonBottomPadding : Dp = 24.dp, onChangeRestaurantCardPageHeight : (Int) -> Unit = {}, onMyLocation : () -> Unit = {}) {
    Box {
        mapScreen.invoke() // 지도화면
        filter.invoke() // 필터화면
        Column(Modifier.align(Alignment.BottomCenter), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
            // 지도 확대, 축소, 내위치 버튼
            Buttons(modifier = Modifier.padding(bottom = buttonBottomPadding), onZoomIn = onZoomIn, onZoomOut = onZoomOut, onMyLocation = onMyLocation)
            Box(modifier = Modifier.onSizeChanged{
                onChangeRestaurantCardPageHeight.invoke(it.height)
            }) {restaurantCardPage.invoke()} // 카드 페이지

        }
    }
}

@Preview
@Composable
fun Buttons(modifier : Modifier = Modifier, onZoomIn: () -> Unit = {}, onZoomOut: () -> Unit = {}, onMyLocation : () -> Unit = {} ) {
    Row(modifier.padding(end = 8.dp )) {

        AssistChip(onZoomIn, label = {Text("+", fontSize = 30.sp)})
        Spacer(modifier = Modifier.width(8.dp))
        AssistChip(onZoomOut, label = { Text("-", fontSize = 30.sp) })
        Spacer(modifier = Modifier.width(8.dp))
        AssistChip(onMyLocation, label = { Icon(Icons.Default.LocationOn, "") })
    }
}
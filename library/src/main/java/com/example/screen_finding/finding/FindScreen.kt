package com.example.screen_finding.finding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cardinfo.RestaurantCardInfo
import com.example.screen_map.Map
import com.sryang.screen_filter.ui.Filter

@Preview
@Composable
fun FindScreen() {
    Box {
        Map()
        Column() {
            Filter()
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.Bottom) {
                RestaurantCardInfo()
            }
        }
    }
}
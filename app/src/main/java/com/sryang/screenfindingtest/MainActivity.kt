package com.sryang.screenfindingtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.cardinfo.RestaurantCardViewModel
import com.example.screen_finding.finding.TextFindScreen
import com.example.screen_map.MapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mapViewModel: MapViewModel by viewModels()
    private val restaurantVardViewModel: RestaurantCardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFindScreen(mapViewModel, restaurantVardViewModel, restaurantImageUrl = "http://sarang628.iptime.org:89/restaurant_images/")
        }
    }
}
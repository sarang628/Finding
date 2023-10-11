package com.sryang.screenfindingtest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cardinfo.RestaurantCardData
import com.example.cardinfo.RestaurantCardPage
import com.example.cardinfo.RestaurantCardViewModel
import com.example.screen_finding.finding.FindScreen
import com.example.screen_finding.finding.FindingViewModel
import com.example.screen_finding.finding.RestaurantInfo
import com.example.screen_map.MapScreen
import com.example.screen_map.MapViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.maps.android.compose.rememberCameraPositionState
import com.sryang.screen_filter.ui.Filter
import com.sryang.screen_filter.ui.FilterViewModel
import com.sryang.screenfindingtest.di.finding.Finding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.streams.toList

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mapViewModel: MapViewModel by viewModels()
    private val restaurantCardViewModel: RestaurantCardViewModel by viewModels()
    private val filterViewModel: FilterViewModel by viewModels()
    private val findingViewModel: FindingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Finding(
                findingViewModel = findingViewModel,
                restaurantCardViewModel = restaurantCardViewModel,
                filterViewModel = filterViewModel,
                mapViewModel = mapViewModel
            )
        }
    }
}
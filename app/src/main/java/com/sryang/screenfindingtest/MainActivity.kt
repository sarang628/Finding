package com.sryang.screenfindingtest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cardinfo.RestaurantCardPage
import com.example.cardinfo.RestaurantCardViewModel
import com.example.screen_finding.finding.FindScreen
import com.example.screen_map.MapScreen
import com.example.screen_map.MapViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.maps.android.compose.rememberCameraPositionState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mapViewModel: MapViewModel by viewModels()
    private val restaurantCardViewModel: RestaurantCardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val cameraPositionState = rememberCameraPositionState()
            val coroutineScope = rememberCoroutineScope()
            val navController = rememberNavController()
            var isMovingByMarkerClick by remember { mutableStateOf(false) }
            NavHost(navController = navController, startDestination = "find") {
                Log.d("MainActivity", restaurantCardViewModel.uiState.value.toString())
                composable("find") {
                    FindScreen(
                        restaurantCardPage = {
                            RestaurantCardPage(
                                uiState = restaurantCardViewModel.uiState,
                                restaurantImageUrl = "http://sarang628.iptime.org:89/restaurant_images/",
                                onChangePage = { page ->
                                    Log.d("MainActivity", "onPageChange : $it")
                                    restaurantCardViewModel.uiState.value.restaurants?.let { restaurants ->
                                        val restaurantId = restaurants[page].restaurantId
                                        restaurantCardViewModel.selectRestaurant(restaurantId)

                                        if (!isMovingByMarkerClick) {
                                            mapViewModel.selectRestaurantById(id = restaurantId)
                                        }
                                    }
                                }, onClickCard = { navController.navigate("detail") }
                            )
                        },
                        mapScreen = {
                            MapScreen(
                                mapViewModel = mapViewModel,
                                onMark = {
                                    isMovingByMarkerClick = true
                                    restaurantCardViewModel.selectRestaurant(it)
                                },
                                animationMoveDuration = 300,
                                onIdle = {
                                    Log.d("MainActivity", "onIdle")
                                    isMovingByMarkerClick = false
                                },
                                cameraPositionState = cameraPositionState
                            )
                        },
                        onZoomIn = {
                            coroutineScope.launch {
                                cameraPositionState.animate(CameraUpdateFactory.zoomIn())
                            }
                        },
                        onZoomOut = {
                            coroutineScope.launch {
                                cameraPositionState.animate(CameraUpdateFactory.zoomOut())
                            }
                        }
                    )
                }
                composable("detail") {
                    Text(text = "")
                }
            }

        }
    }
}
package com.sryang.screenfindingtest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cardinfo.RestaurantCardPage
import com.example.cardinfo.RestaurantCardViewModel
import com.example.screen_finding.finding.FindScreen
import com.example.screen_map.MapScreen
import com.example.screen_map.MapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mapViewModel: MapViewModel by viewModels()
    private val restaurantCardViewModel: RestaurantCardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            var isMovingByMarkerClick = false
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

                                        if (!isMovingByMarkerClick)
                                            mapViewModel.selectRestaurantById(id = restaurantId)
                                    }
                                }, onClickCard = { navController.navigate("detail") }
                            )
                        },
                        mapScreen = {
                            MapScreen(
                                mapViewModel = mapViewModel,
                                mapViewModel.mapUiStateFlow,
                                onMark = {
                                    isMovingByMarkerClick = true
                                    restaurantCardViewModel.selectRestaurant(it)
                                },
                                animationMoveDuration = 300,
                                onIdle = {
                                    isMovingByMarkerClick = false
                                }
                            )
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
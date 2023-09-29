package com.sryang.screenfindingtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.navigation.NavGraph
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cardinfo.RestaurantCardPage
import com.example.cardinfo.RestaurantCardViewModel
import com.example.screen_finding.finding.FindScreen
import com.example.screen_map.MapScreen
import com.example.screen_map.MapViewModel
import com.example.screen_map.MarkerData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mapViewModel: MapViewModel by viewModels()
    private val restaurantVardViewModel: RestaurantCardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "find") {
                composable("find") {
                    FindScreen(
                        restaurantCardPage = {
                            RestaurantCardPage(
                                uiState = restaurantVardViewModel.uiState,
                                restaurantImageUrl = "http://sarang628.iptime.org:89/restaurant_images/",
                                onChangePage = {
                                    /*mapViewModel.selectRestaurantById(
                                        id = restaurantVardViewModel.uiState.value.restaurants[it].restaurantId
                                    )*/
                                }, onClickCard = {navController.navigate("detail")}
                            )
                        },
                        mapScreen = {
                            MapScreen(
                                mapViewModel = mapViewModel,
                                mapViewModel.mapUiStateFlow,
                                onMark = { restaurantVardViewModel.selectRestaurant(it) }
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
package com.sryang.screenfindingtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.cardinfo.RestaurantCardPage
import com.example.cardinfo.RestaurantCardViewModel
import com.example.screen_finding.finding.FindScreen
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
            FindScreen(mapViewModel, onMark = {
                restaurantVardViewModel.selectRestaurant(it)
            },
                restaurantCardPage = {
                    RestaurantCardPage(
                        uiState = restaurantVardViewModel.uiState,
                        restaurantImageUrl = "http://sarang628.iptime.org:89/restaurant_images/",
                        onChangePage = {
                            if (restaurantVardViewModel.uiState.value.restaurants.size > it) {
                                mapViewModel.selectRestaurant(
                                    MarkerData(
                                        id = restaurantVardViewModel.uiState.value.restaurants[it].restaurantId
                                    )
                                )
                            }
                        }, onClickCard = {}
                    )
                }
            )
        }
    }
}
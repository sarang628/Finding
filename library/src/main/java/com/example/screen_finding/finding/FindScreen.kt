package com.example.screen_finding.finding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.cardinfo.RestaurantCardPage
import com.example.cardinfo.RestaurantCardViewModel
import com.example.cardinfo.RestaurantInfoCardUiState
import com.example.cardinfo.TestRestaurantCard
import com.example.library.data.Restaurant
import com.example.screen_map.Map
import com.example.screen_map.MapScreen
import com.example.screen_map.MapViewModel
import com.sryang.screen_filter.ui.Filter
import kotlinx.coroutines.flow.StateFlow

@Composable
fun FindScreen(uiState: StateFlow<RestaurantInfoCardUiState>) {
    Box {
        Map()
        Column {
            Filter()
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.Bottom) {
                RestaurantCardPage(uiState)
            }
        }
    }
}

@Composable
fun TextFindScreen() {
    Box {
        val restaurantVardViewModel = RestaurantCardViewModel(LocalContext.current)
        val mapViewModel = MapViewModel(LocalContext.current)
        MapScreen(mapViewModel.mapUiStateFlow, onMark = {
            restaurantVardViewModel.selectRestaurant(it)
        })
        Column {
            Filter()
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.Bottom) {
                RestaurantCardPage(restaurantVardViewModel.uiState) {
                    mapViewModel.selectRestaurant(
                        Restaurant(
                            restaurant_id = restaurantVardViewModel.uiState.value.restaurants[it].restaurantId
                        )
                    )
                }
            }
        }
    }
}
package com.example.screen_finding.uistate

import android.location.Location
import com.example.screen_finding.data.RestaurantInfo

data class FindingUiState(
    val restaurants: List<RestaurantInfo>,
    val selectedRestaurant: RestaurantInfo? = null,
    val currentLocation : Location? = null
)
package com.example.screen_finding.finding

import android.location.Location

data class FindingUiState(
    val restaurants: List<RestaurantInfo>,
    val selectedRestaurant: RestaurantInfo? = null,
    val currentLocation : Location? = null
)
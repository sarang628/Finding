package com.example.screen_finding.finding

data class FindingUiState(
    val restaurants: List<RestaurantInfo>,
    val selectedRestaurant: RestaurantInfo? = null
)
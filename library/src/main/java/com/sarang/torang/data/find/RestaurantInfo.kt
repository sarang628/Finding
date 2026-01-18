package com.sarang.torang.data.find

data class RestaurantInfo(
    val restaurantId: Int,
    val restaurantName: String,
    val rating: Float,
    val foodType: String,
    val restaurantImage: String,
    val price: String,
    val distance: String,
    val lat: Double = 0.0,
    val lon: Double = 0.0,
)
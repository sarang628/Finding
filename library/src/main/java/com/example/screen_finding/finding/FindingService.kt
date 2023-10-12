package com.example.screen_finding.finding

interface FindingService {
    suspend fun findRestaurants(): List<RestaurantInfo>
    suspend fun filter(filter: Filter): List<RestaurantInfo>
}
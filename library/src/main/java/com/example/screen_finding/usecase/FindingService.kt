package com.example.screen_finding.usecase

import com.example.screen_finding.data.RestaurantInfo
import com.example.screen_finding.viewmodel.Filter

interface FindingService {
    suspend fun findRestaurants(): List<RestaurantInfo>
    suspend fun filter(filter: Filter): List<RestaurantInfo>
}
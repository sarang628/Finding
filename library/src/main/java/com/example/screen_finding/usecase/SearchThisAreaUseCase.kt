package com.example.screen_finding.usecase

import com.example.screen_finding.data.RestaurantInfo
import com.example.screen_finding.viewmodel.Filter

interface SearchThisAreaUseCase {
    suspend fun invoke(filter: Filter): List<RestaurantInfo>
}
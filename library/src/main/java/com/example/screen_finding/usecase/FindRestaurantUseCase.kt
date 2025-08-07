package com.example.screen_finding.usecase

import com.example.screen_finding.viewmodel.Filter

interface FindRestaurantUseCase {
    suspend fun filter(filter: Filter)
}
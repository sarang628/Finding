package com.sarang.torang.usecase

import com.sarang.torang.data.finding.FindingFilter

interface FindRestaurantUseCase {
    suspend fun filter(filter: FindingFilter)
}
package com.sarang.torang.usecase

import com.sarang.torang.data.finding.FindingFilter
import com.sarang.torang.data.finding.RestaurantInfo

interface SearchByKeywordUseCase {
    suspend fun invoke(filter: FindingFilter): List<RestaurantInfo>
}
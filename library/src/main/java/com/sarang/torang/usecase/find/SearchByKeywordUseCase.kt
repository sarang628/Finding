package com.sarang.torang.usecase.find

import com.sarang.torang.data.find.FindFilter
import com.sarang.torang.data.find.RestaurantInfo

interface SearchByKeywordUseCase {
    suspend fun invoke(filter: FindFilter): List<RestaurantInfo>
}
package com.sarang.torang.usecase.find

import com.sarang.torang.data.find.FindFilter

interface FindRestaurantUseCase {
    suspend fun filter(filter: FindFilter)
}
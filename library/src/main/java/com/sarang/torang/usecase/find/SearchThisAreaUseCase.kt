package com.sarang.torang.usecase.find

import com.sarang.torang.data.find.FindFilter

interface SearchThisAreaUseCase {
    suspend fun invoke(filter: FindFilter)
}
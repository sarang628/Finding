package com.sarang.torang.usecase

import com.sarang.torang.data.finding.FindingFilter

interface SearchThisAreaUseCase {
    suspend fun invoke(filter: FindingFilter)
}
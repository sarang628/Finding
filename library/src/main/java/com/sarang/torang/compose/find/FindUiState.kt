package com.sarang.torang.compose.find

import android.location.Location

data class FindUiState(
    val currentLocation : Location? = null,
    val errorMessage : List<String> = listOf(),
)

fun FindUiState.addErrorMessage(string: String): FindUiState {
    return this.copy(errorMessage = this.errorMessage + string)
}

fun FindUiState.popErrorMessage(): FindUiState {
    return this.copy(errorMessage = errorMessage.drop(0))
}
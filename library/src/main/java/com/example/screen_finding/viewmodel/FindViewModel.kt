package com.example.screen_finding.viewmodel

import android.location.Location
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.screen_finding.data.RestaurantInfo
import com.example.screen_finding.uistate.FindUiState
import com.example.screen_finding.usecase.SearchByKeywordUseCase
import com.example.screen_finding.usecase.SearchThisAreaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindViewModel @Inject constructor(
    private val searchThisAreaUseCase: SearchThisAreaUseCase,
    private val searchByKeywordUseCase: SearchByKeywordUseCase,
) : ViewModel() {
    var uiState by mutableStateOf(FindUiState())
        private set

    fun handleException(e: Exception) { e.message?.let { uiState = uiState.addErrorMessage(it) } }

    fun selectMarker(restaurantId: Int) {}

    fun selectPage(page: Int) {}

    fun setCurrentLocation(location: Location) {
        viewModelScope.launch { uiState = uiState.copy(currentLocation = location) }
    }

    fun findThisArea(filter: Filter) {
        viewModelScope.launch {
            try {
                searchThisAreaUseCase.invoke(filter = filter)
            } catch (e: Exception) { handleException(e) }
        }
    }

    fun clearErrorMessage() { uiState =  uiState.popErrorMessage() }
    fun findPositionByRestaurantId(restaurantId: Int): RestaurantInfo? { return null }

    fun onSearch(it: Filter) {
        viewModelScope.launch {
            try {
                val result = searchByKeywordUseCase.invoke(it)
                if (result.isEmpty()) uiState = uiState.addErrorMessage( "No results were found")
            }catch (e : Exception){ Log.e("__FindingViewModel", e.toString()) }
        }
    }
}

private fun FindUiState.addErrorMessage(string: String): FindUiState {
    return this.copy(errorMessage = this.errorMessage + string)
}

private fun FindUiState.popErrorMessage(): FindUiState {
    return this.copy(errorMessage = errorMessage.drop(0))
}

data class Filter(
    var searchType: String = "AROUND",
    var keyword: String? = null,
    var distances: String? = null,
    var prices: List<String>? = null,
    var restaurantTypes: List<String>? = null,
    var ratings: List<String>? = null,
    var lat: Double? = null,
    var lon: Double? = null,
    var north: Double = 0.0,
    var east: Double = 0.0,
    var south: Double = 0.0,
    var west: Double = 0.0,
)
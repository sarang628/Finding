package com.example.screen_finding.viewmodel

import android.location.Location
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.screen_finding.data.RestaurantInfo
import com.example.screen_finding.uistate.FindingUiState
import com.example.screen_finding.usecase.FindRestaurantUseCase
import com.example.screen_finding.usecase.SearchByKeywordUseCase
import com.example.screen_finding.usecase.SearchThisAreaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindingViewModel @Inject constructor(
    private val findRestaurantUseCase: FindRestaurantUseCase,
    private val searchThisAreaUseCase: SearchThisAreaUseCase,
    private val searchByKeywordUseCase: SearchByKeywordUseCase,
) : ViewModel() {
    var uiState by mutableStateOf(FindingUiState())
        private set

    fun filter(filter: Filter) {
        viewModelScope.launch {
            try {
                val result = findRestaurantUseCase.filter(filter)
                uiState = uiState.copy(restaurants = result, errorMessage = if (result.isEmpty()) "No results were found" else null)
            } catch (e: Exception) { handleException(e) }
        }
    }

    fun handleException(e: Exception) {
        uiState = uiState.copy(errorMessage = e.message)
    }

    fun selectMarker(restaurantId: Int) {
        viewModelScope.launch {
            val selectedRestaurant = uiState.restaurants.find { it.restaurantId == restaurantId }
            uiState = uiState.copy(selectedRestaurant = selectedRestaurant)
        }
    }

    fun selectPage(page: Int) {
        viewModelScope.launch {
            if (uiState.restaurants.size - 1 < page) return@launch
            val selectedRestaurant = uiState.restaurants.get(page)
            uiState = uiState.copy(selectedRestaurant = selectedRestaurant)
        }
    }

    fun setCurrentLocation(location: Location) {
        viewModelScope.launch { uiState = uiState.copy(currentLocation = location) }
    }

    fun findThisArea(filter: Filter) {
        viewModelScope.launch {
            try {//필터화면에서 보내주는 정보는 맵의 visibleBound를 가지고 있지 않아 usecase에서 mapRepository와 함께 사용하여 처리
                val result = searchThisAreaUseCase.invoke(filter = filter)
                uiState = uiState.copy(restaurants = result, errorMessage = if (result.isEmpty()) "No results were found" else null)
            } catch (e: Exception) { handleException(e) }
        }
    }

    fun clearErrorMessage() {
        uiState =  uiState.copy(errorMessage = null)
    }

    fun findPositionByRestaurantId(restaurantId: Int): RestaurantInfo? {
        return uiState.restaurants.find { it.restaurantId == restaurantId }
    }

    fun onSearch(it: Filter) {
        viewModelScope.launch {
            try {
                val result = searchByKeywordUseCase.invoke(it)
                uiState = uiState.copy(restaurants = result, errorMessage = if (result.isEmpty()) "No results were found" else null)
            }catch (e : Exception){ Log.e("__FindingViewModel", e.toString()) }
        }
    }
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
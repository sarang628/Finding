package com.example.screen_finding.viewmodel

import android.location.Location
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.screen_finding.usecase.FindingService
import com.example.screen_finding.uistate.FindingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindingViewModel @Inject constructor(
    val findingService: FindingService
) : ViewModel() {
    private val _uiState = MutableStateFlow(FindingUiState(ArrayList()))
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val result = findingService.findRestaurants()
            _uiState.emit(
                uiState.value.copy(
                    restaurants = result,
                    selectedRestaurant = if (!result.isEmpty()) result[0] else null
                )
            )
        }
    }

    fun filter(filter: Filter) {
        viewModelScope.launch {
            val result = findingService.filter(filter)
            _uiState.emit(
                uiState.value.copy(
                    restaurants = result,
                    selectedRestaurant = if (!result.isEmpty()) result[0] else null
                )
            )
        }
    }

    fun selectMarker(restaurantId: Int) {
        Log.d("FindingViewModel", "selectMarker:$restaurantId")
        viewModelScope.launch {
            val selectedRestaurant =
                _uiState.value.restaurants.find { it.restaurantId == restaurantId }
            Log.d("FindingViewModel", "selectMarker:$selectedRestaurant")
            _uiState.emit(
                uiState.value.copy(
                    selectedRestaurant = selectedRestaurant
                )
            )
        }
    }

    fun selectPage(page: Int) {
        viewModelScope.launch {
            if (_uiState.value.restaurants.size - 1 < page)
                return@launch

            val selectedRestaurant = _uiState.value.restaurants[page]
            Log.d("FindingViewModel", "selectPage:$selectedRestaurant")
            _uiState.emit(
                uiState.value.copy(
                    selectedRestaurant = selectedRestaurant
                )
            )
        }
    }

    fun setCurrentLocation(it: Location) {
        viewModelScope.launch {
            _uiState.emit(
                uiState.value.copy(
                    currentLocation = it
                )
            )
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
    var west: Double = 0.0
)
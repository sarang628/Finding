package com.example.screen_finding.finding

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindingViewModel @Inject constructor(
    findingService: FindingService
) : ViewModel() {
    private val _uiState = MutableStateFlow(FindingUiState(ArrayList()))
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.emit(
                uiState.value.copy(restaurants = findingService.findRestaurants())
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
}
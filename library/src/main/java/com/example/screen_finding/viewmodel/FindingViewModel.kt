package com.example.screen_finding.viewmodel

import android.location.Location
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
    private val _uiState = MutableStateFlow(FindingUiState(ArrayList()))
    val uiState = _uiState.asStateFlow()

    fun filter(filter: Filter) {
        viewModelScope.launch {
            try {
                val result = findRestaurantUseCase.filter(filter)
                _uiState.update {
                    it.copy(
                        restaurants = result,
                        errorMessage = if (result.isEmpty()) "No results were found" else null
                    )
                }
            } catch (e: Exception) {
                handleException(e)
            }
        }
    }

    fun handleException(e: Exception) {
        _uiState.update { it.copy(errorMessage = e.message) }
    }

    fun selectMarker(restaurantId: Int) {
        viewModelScope.launch {
            val selectedRestaurant =
                _uiState.value.restaurants?.find { it.restaurantId == restaurantId }
            _uiState.update {
                it.copy(
                    selectedRestaurant = selectedRestaurant
                )
            }
        }
    }

    fun selectPage(page: Int) {
        viewModelScope.launch {
            if ((_uiState.value.restaurants?.size ?: 0) - 1 < page)
                return@launch
            val selectedRestaurant = _uiState.value.restaurants?.get(page)
            _uiState.update {
                it.copy(
                    selectedRestaurant = selectedRestaurant
                )
            }
        }
    }

    fun setCurrentLocation(location: Location) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    currentLocation = location
                )
            }
        }
    }

    fun findThisArea(filter: Filter) {
        viewModelScope.launch {
            //필터화면에서 보내주는 정보는 맵의 visibleBound를 가지고 있지 않아 usecase에서 mapRepository와 함께 사용하여 처리
            try {
                val result = searchThisAreaUseCase.invoke(filter = filter)
                _uiState.update {
                    it.copy(
                        restaurants = result,
                        errorMessage = if (result.isEmpty()) "No results were found" else null
                    )
                }
            } catch (e: Exception) {
                handleException(e)
            }
        }
    }

    fun clearErrorMessage() {
        _uiState.update { it.copy(errorMessage = null) }
    }

    fun findPositionByRestaurantId(restaurantId: Int): RestaurantInfo? {
        return _uiState.value.restaurants?.find { it.restaurantId == restaurantId }
    }

    fun onSearch(it: Filter) {
        viewModelScope.launch {
            val result = searchByKeywordUseCase.invoke(it)
            _uiState.update {
                it.copy(
                    restaurants = result,
                    errorMessage = if (result.isEmpty()) "No results were found" else null
                )
            }
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
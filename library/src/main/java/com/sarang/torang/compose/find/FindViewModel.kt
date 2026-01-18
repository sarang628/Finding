package com.sarang.torang.compose.find

import android.location.Location
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sarang.torang.data.find.FindFilter
import com.sarang.torang.data.find.RestaurantInfo
import com.sarang.torang.usecase.find.SearchByKeywordUseCase
import com.sarang.torang.usecase.find.SearchThisAreaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
private const val tag = "__FindingViewModel"
@HiltViewModel
class FindViewModel @Inject constructor(
    private val searchThisAreaUseCase: SearchThisAreaUseCase,
    private val searchByKeywordUseCase: SearchByKeywordUseCase,
) : ViewModel() {
    var uiState by mutableStateOf(FindUiState())
        private set

    /** 에러 메세지 처리 */
    fun handleException(e: Exception) { e.message?.let { uiState = uiState.addErrorMessage(it) } }

    /** 마커 선택 */
    fun selectMarker(restaurantId: Int) {}

    /** 페이지 선택 */
    fun selectPage(page: Int) {}

    /** 위치 저장 */
    fun setCurrentLocation(location: Location) {
        viewModelScope.launch { uiState = uiState.copy(currentLocation = location) }
    }

    /** 이 지역 찾기 */
    fun findThisArea(filter: FindFilter) {
        viewModelScope.launch {
            try {
                searchThisAreaUseCase.invoke(filter = filter)
            } catch (e: Exception) { handleException(e) }
        }
    }
    /** 메세지 지우기 */
    fun clearErrorMessage() { uiState =  uiState.popErrorMessage() }

    /** 음식점 Id로 위치 찾기 */
    fun findPositionByRestaurantId(restaurantId: Int): RestaurantInfo? { return null }

    /** 필터 검색 */
    fun onSearch(it: FindFilter) {
        viewModelScope.launch {
            try {
                val result = searchByKeywordUseCase.invoke(it)
                if (result.isEmpty()) uiState = uiState.addErrorMessage( "No results were found")
            }catch (e : Exception){ Log.e(tag, e.toString()) }
        }
    }
}
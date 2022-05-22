package com.example.screen_finding.finding

import android.content.pm.PackageManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.torang_core.data.model.SearchType
import com.example.torang_core.repository.*
import com.example.torang_core.util.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindViewModel @Inject constructor(
    private val searchRepository: SearchRepository,
    private val findingRepository: FindRepository,
    private val filterRepository: FilterRepository,
    private val mapRepository: MapRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(FindUiState())
    val uiState: StateFlow<FindUiState> = _uiState

    init {
        viewModelScope.launch {
            subScribe()
        }
    }

    @OptIn(InternalCoroutinesApi::class)
    suspend fun subScribe() {
        // 현재 위치를 요청중인지
        viewModelScope.launch {
            findingRepository.isRequestingLocation().collect(FlowCollector { b ->
                _uiState.update {
                    it.copy(isRequestingLocation = b)
                }
            })
        }

        viewModelScope.launch {
            // 검색된 맛집 리스트
            findingRepository.getSearchBoundRestaurnatTrigger().collect(FlowCollector {
                if (it) {
                    val filter = filterRepository.getFilter()
                    findingRepository.searchRestaurant(
                        distances = filter.distances,
                        restaurantType = filter.restaurantTypes,
                        prices = filter.prices,
                        ratings = filter.ratings,
                        northEastLatitude = mapRepository.getNorthEastLatitude(),
                        northEastLongitude = mapRepository.getNorthEastLongitude(),
                        southWestLatitude = mapRepository.getSouthWestLatitude(),
                        southWestLongitude = mapRepository.getSouthWestLongitude(),
                        searchType = SearchType.BOUND
                    )
                }
            })
        }

        viewModelScope.launch {
            findingRepository.hasGrantPermission().collect(FlowCollector { permission ->
                _uiState.update { it.copy(hasGrantLocationPermission = (permission == PackageManager.PERMISSION_GRANTED)) }
            })
        }
    }

    // 위치 요청하기
    fun requestLocation() {
        viewModelScope.launch {
            when (findingRepository.notifyRequestLocation()) {
                // 첫 요청 시 권한 필요 팝업 상태 변경
                RequestLocationResult.NEED_LOCATION_PERMISSION -> {
                    _uiState.update { it.copy(showLocationPermissionDialogPopup = true) }
                    delay(100)
                    _uiState.update { it.copy(showLocationPermissionDialogPopup = false) }
                }
                // 권한 거부 시 설정 화면 이동 팝업 상태 변경
                RequestLocationResult.PERMISSION_DENIED -> {
                    _uiState.update { it.copy(showNeedPermissionPopup = true) }
                    delay(100)
                    _uiState.update { it.copy(showNeedPermissionPopup = false) }
                }
                RequestLocationResult.GPS_OFF -> {
                    _uiState.update { it.copy(gpsOff = true) }
                    delay(100)
                    _uiState.update { it.copy(gpsOff = false) }
                }
            }
        }
    }

    fun search(keyword: String) {
        viewModelScope.launch {
            Logger.d(keyword)
            searchRepository.saveHistory(keyword)
        }
    }

    fun permissionGranated() {
        Logger.d("call permissionGranated in viewmodel")
        viewModelScope.launch {
            findingRepository.permissionGranated()
        }
    }
}
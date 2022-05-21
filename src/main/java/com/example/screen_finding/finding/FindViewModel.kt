package com.example.screen_finding.finding

import android.content.pm.PackageManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.torang_core.data.model.SearchType
import com.example.torang_core.repository.FilterRepository
import com.example.torang_core.repository.FindRepository
import com.example.torang_core.repository.MapRepository
import com.example.torang_core.repository.SearchRepository
import com.example.torang_core.util.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
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
            findingRepository.isFirstRequestLocationPermission().collect(FlowCollector { b ->
                _uiState.update {
                    it.copy(
                        showLocationPermissionDialogPopup = b
                    )
                }
            })
        }

        viewModelScope.launch {
            findingRepository.hasGrantPermission().collect(FlowCollector { grant ->
                _uiState.update {
                    Logger.d("is location permission granted :  ${grant == PackageManager.PERMISSION_GRANTED}")
                    it.copy(
                        hasGrantLocationPermission = (grant == PackageManager.PERMISSION_GRANTED)
                    )
                }
            })
        }
    }

    // 상태를 가져오고 뷰에서 위치 요청을 했다면 요청했다고 저장소에 알려주기
    fun requestLocation() {
        viewModelScope.launch {
            findingRepository.checkFirstRequestLocationPermission()
            if (findingRepository.hasGrantPermission().value == PackageManager.PERMISSION_GRANTED) {
                findingRepository.notifyRequestLocation()
            }
        }
    }

    fun search(keyword: String) {
        viewModelScope.launch {
            Logger.d(keyword)
            searchRepository.saveHistory(keyword)
        }
    }

    fun requestLocationPermission(b: Boolean) {

        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    showLocationPermissionDialogPopup = false
                )
            }
        }

        viewModelScope.launch {
            //저장소에 권한 요청에 대한 사용자의 응답을 보냄
            findingRepository.requestLocationPermission(b)
        }

        // 사용자가 권한팝업을 나오도록 허용했다면
        if (b) {
            viewModelScope.launch {
                _uiState.update {
                    it.copy(
                        showLocationSystemPermission = true
                    )
                }
            }
        }
    }

    fun permissionGranated() {
        viewModelScope.launch {
            findingRepository.permissionGranated()
        }
    }
}
package com.example.screen_finding.finding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.torang_core.data.model.SearchType
import com.example.torang_core.repository.FilterRepository
import com.example.torang_core.repository.FindRepository
import com.example.torang_core.repository.MapRepository
import com.example.torang_core.repository.SearchRepository
import com.example.torang_core.util.Logger
import com.sryang.screen_filter.databinding.FragmentPriceFilterBindingImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindViewModel @Inject constructor(
    private val searchRepository: SearchRepository,
    private val findingRepository: FindRepository,
    private val filterRepository: FilterRepository,
    private val mapRepository: MapRepository
) : ViewModel() {
    private val isFocusSearchView = MutableLiveData<Boolean>()
    private val _uiState = MutableStateFlow(FindUiState())
    val uiState: StateFlow<FindUiState> = _uiState

    init {
        viewModelScope.launch {
            // 최초위치요청 상태 가져오기
            findingRepository.getIsFirstRequestLocation().collectLatest { b ->
                _uiState.update {
                    Logger.d("getIsFirstRequestLocation:" + b)
                    it.copy(isFirstRequestLocation = b)
                }
            }
        }

        // 현재 위치를 요청중인지
        viewModelScope.launch {
            findingRepository.isRequestingLocation().collectLatest { b ->
                Logger.d("isRequestingLocation:" + b)
                _uiState.update {
                    it.copy(isRequestingLocation = b)
                }
            }
        }

        viewModelScope.launch {
            findingRepository.getSearchBoundRestaurnatTrigger().collectLatest {
                Logger.d("getSearchBoundRestaurnatTrigger: $it")
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
            }
        }
    }

    // 상태를 가져오고 뷰에서 위치 요청을 했다면 요청했다고 저장소에 알려주기
    fun requestLocation() {
        viewModelScope.launch {
            findingRepository.notifyRequestLocation()
        }
    }

    // 위치를 받아왔을때 알려줘야함
    fun onReceiveLocation() {
        viewModelScope.launch {
            findingRepository.notifyReceiveLocation()
        }
    }

    fun search(keyword: String) {
        viewModelScope.launch {
            Logger.d(keyword)
            searchRepository.saveHistory(keyword)
        }
    }

    fun setIsFocusSearchView(isFocusSearchView: Boolean) {
        this.isFocusSearchView.value = isFocusSearchView
    }
}
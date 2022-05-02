package com.example.screen_finding.finding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.torang_core.repository.FindRepository
import com.example.torang_core.repository.SearchRepository
import com.example.torang_core.util.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindViewModel @Inject constructor(
    private val searchRepository: SearchRepository,
    private val findingRepository: FindRepository
) : ViewModel() {
    private val isFocusSearchView = MutableLiveData<Boolean>()

    private val _uiState = MutableStateFlow(FindUiState())
    val uiState: StateFlow<FindUiState> = _uiState


    fun setIsFocusSearchView(isFocusSearchView: Boolean) {
        this.isFocusSearchView.value = isFocusSearchView
    }


    init {
        viewModelScope.launch {
            findingRepository.getIsFirstRequestLocation().collect { b ->
                _uiState.update {
                    Logger.d("getIsFirstRequestLocation:" + b)
                    it.copy(isFirstRequestLocation = b)
                }
            }
        }

        viewModelScope.launch {
            findingRepository.isRequestingLocation().collect { b ->
                Logger.d("isRequestingLocation:" + b)
                _uiState.update {
                    it.copy(isRequestingLocation = b)
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

    fun requestLocation() {
        viewModelScope.launch {
            Logger.d("")
            findingRepository.notifyRequestedLocation()
        }
    }

    fun onReceiveLocation() {
        viewModelScope.launch {
            delay(3000)
            findingRepository.onReceiveLocation()
        }
    }
}
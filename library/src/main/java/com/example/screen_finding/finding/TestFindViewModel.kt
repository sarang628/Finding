package com.example.screen_finding.finding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sryang.torang_core.util.Logger
import com.sryang.torang_repository.repository.FindRepository
import com.sryang.torang_repository.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestFindViewModel @Inject constructor(
    private val searchRepository: SearchRepository,
    private val findingRepository: FindRepository
) : ViewModel() {
    private val isFocusSearchView = MutableLiveData<Boolean>()

    private val _uiState = MutableStateFlow(FindUiState())
    val uiState: StateFlow<FindUiState> = _uiState

    init {
        viewModelScope.launch {
            while (true) {
                delay(2000)
                _uiState.update {
                    it.copy(isRequestingLocation = !it.isRequestingLocation)
                }
            }
        }
    }

    fun setIsFocusSearchView(isFocusSearchView: Boolean) {
        this.isFocusSearchView.value = isFocusSearchView
    }

    fun search(keyword: String) {
        viewModelScope.launch {
            Logger.d(keyword)
            searchRepository.saveHistory(keyword)
        }
    }

    fun requestLocation() {
        viewModelScope.launch {

        }
    }

    fun onReceiveLocation() {
        viewModelScope.launch {

        }
    }
}
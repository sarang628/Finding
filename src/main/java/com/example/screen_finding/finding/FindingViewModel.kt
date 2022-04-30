package com.example.screen_finding.finding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.torang_core.repository.FindRepository
import com.example.torang_core.repository.SearchRepository
import com.example.torang_core.util.Logger
import kotlinx.coroutines.launch

class FindingViewModel(
    private val searchRepository: SearchRepository,
    private val findingRepository: FindRepository
) : ViewModel() {
    private val isFocusSearchView = MutableLiveData<Boolean>()
    fun setIsFocusSearchView(isFocusSearchView: Boolean) {
        this.isFocusSearchView.value = isFocusSearchView
    }

    fun search(keyword: String) {
        viewModelScope.launch {
            Logger.d(keyword)
            searchRepository.saveHistory(keyword)
        }
    }
}
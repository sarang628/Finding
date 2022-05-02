package com.example.screen_finding.finding

data class FindUiState(
    val isRequestingLocation: Boolean = false, // 위치를 요청중인지
    val isFirstRequestLocation : Boolean = false // 위치를 처음 요청하였는지
)
package com.sarang.torang.compose.find

import android.location.Location

/**
 * @param restaurants 검색된 음식점 리스트
 * @param selectedRestaurant 현재 선택된 음식점
 * @param currentLocation 현재 내 위치
 * @param errorMessage 에러메시지
 */
data class FindUiState(
    val currentLocation : Location? = null,
    val errorMessage : List<String> = listOf(),
)
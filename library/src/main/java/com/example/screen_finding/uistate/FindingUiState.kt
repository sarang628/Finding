package com.example.screen_finding.uistate

import android.location.Location
import com.example.screen_finding.data.RestaurantInfo

/**
 * @param restaurants 검색된 음식점 리스트
 * @param selectedRestaurant 현재 선택된 음식점
 * @param currentLocation 현재 내 위치
 * @param errorMessage 에러메시지
 */
data class FindingUiState(
    val restaurants: List<RestaurantInfo> = listOf(),
    val selectedRestaurant: RestaurantInfo? = null,
    val currentLocation : Location? = null,
    val errorMessage : String? = null,
)
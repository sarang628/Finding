package com.example.screen_finding.uistate

import android.location.Location
import com.example.screen_finding.data.RestaurantInfo

data class FindingUiState(
    val restaurants: List<RestaurantInfo>,          //검색된 음식점 리스트
    val selectedRestaurant: RestaurantInfo? = null, //현재 선택된 음식점
    val currentLocation : Location? = null          //현재 내 위치
)
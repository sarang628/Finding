package com.example.screen_finding.finding

import com.example.screen_finding.R

data class FindUiState(
    val isRequestingLocation: Boolean = false, // 위치를 요청중인지
    val showLocationSystemPermission: Boolean = false, // 위치권한 시스템 팝업
    val showLocationPermissionDialogPopup: Boolean = false, // 위치권한 필요 알림 팝업
    val hasGrantLocationPermission: Boolean = false // 위치권한 얻었는지 여부
)
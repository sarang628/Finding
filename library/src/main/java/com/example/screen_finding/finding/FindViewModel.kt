package com.example.screen_finding.finding

//@HiltViewModel
//class FindViewModel @Inject constructor(
//    private val searchRepository: SearchRepository,
//    private val findingRepository: FindRepository,
//    private val filterRepository: FilterRepository,
//    private val mapRepository: MapRepository,
//    private val nationRepository: NationRepository
//) : ViewModel() {
//    private val _uiState = MutableStateFlow(FindUiState())
//    val uiState: StateFlow<FindUiState> = _uiState
//
//    init {
//        viewModelScope.launch {
//            subScribe()
//        }
//
//        viewModelScope.launch {
//            findingRepository.searchIfRestaurantEmpty()
//        }
//    }
//
//    @OptIn(InternalCoroutinesApi::class)
//    suspend fun subScribe() {
//        // 현재 위치를 요청중인지
//        viewModelScope.launch {
//            findingRepository.isRequestingLocation().collect(FlowCollector { b ->
//                _uiState.update {
//                    it.copy(isRequestingLocation = b)
//                }
//            })
//        }
//
//        viewModelScope.launch {
//            // 권한 여부 listening
//            findingRepository.hasGrantPermission().collect(FlowCollector { permission ->
//                _uiState.update { it.copy(hasGrantLocationPermission = (permission == PackageManager.PERMISSION_GRANTED)) }
//            })
//        }
//
//        viewModelScope.launch {
//            nationRepository.getSelectNationItem().collect(FlowCollector {
//                it.nationBound?.let {
//                    searchBoundRestaurant(
//                        northEastLatitude = it.latitudeNorthEast,
//                        northEastLongitude = it.longitudeNorthEast,
//                        southWestLatitude =  it.latitudeSouthWest,
//                        southWestLongitude = it.longitudeSouthWest
//                    )
//                }
//            })
//        }
//    }
//
//    private suspend fun searchBoundRestaurant(
//        northEastLatitude: Double,
//        northEastLongitude: Double,
//        southWestLatitude: Double,
//        southWestLongitude: Double
//    ) {
//        val filter = filterRepository.getFilter()
//        findingRepository.searchRestaurant(
//            distances = filter.distances,
//            restaurantType = filter.restaurantTypes,
//            prices = filter.prices,
//            ratings = filter.ratings,
//            northEastLatitude = northEastLatitude,
//            northEastLongitude = northEastLongitude,
//            southWestLatitude = southWestLatitude,
//            southWestLongitude = southWestLongitude,
//            searchType = SearchType.BOUND
//        )
//    }
//
//    // 위치 요청하기
//    fun requestLocation() {
//        viewModelScope.launch {
//            when (findingRepository.notifyRequestLocation()) {
//                // 첫 요청 시 권한 필요 팝업 상태 변경
//                RequestLocationResult.NEED_LOCATION_PERMISSION -> {
//                    _uiState.update { it.copy(showLocationPermissionDialogPopup = true) }
//                    delay(100)
//                    _uiState.update { it.copy(showLocationPermissionDialogPopup = false) }
//                }
//                // 권한 거부 시 설정 화면 이동 팝업 상태 변경
//                RequestLocationResult.PERMISSION_DENIED -> {
//                    _uiState.update { it.copy(showNeedPermissionPopup = true) }
//                    delay(100)
//                    _uiState.update { it.copy(showNeedPermissionPopup = false) }
//                }
//                RequestLocationResult.GPS_OFF -> {
//                    _uiState.update { it.copy(gpsOff = true) }
//                    delay(100)
//                    _uiState.update { it.copy(gpsOff = false) }
//                }
//            }
//        }
//    }
//
//    fun search(keyword: String) {
//        viewModelScope.launch {
//            Logger.d(keyword)
//            searchRepository.saveHistory(keyword)
//        }
//    }
//
//    fun permissionGranated() {
//        Logger.d("call permissionGranated in viewmodel")
//        viewModelScope.launch {
//            findingRepository.permissionGranated()
//        }
//    }
//}
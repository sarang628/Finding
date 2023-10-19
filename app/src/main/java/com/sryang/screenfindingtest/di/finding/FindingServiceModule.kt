package com.sryang.screenfindingtest.di.finding

import android.location.Location
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cardinfo.RestaurantCardData
import com.example.cardinfo.RestaurantCardPage
import com.example.cardinfo.RestaurantCardViewModel
import com.example.screen_finding.finding.Filter
import com.example.screen_finding.finding.FindScreen
import com.example.screen_finding.finding.FindingService
import com.example.screen_finding.finding.FindingViewModel
import com.example.screen_finding.finding.RestaurantInfo
import com.example.screen_map.CurrentLocationScreen
import com.example.screen_map.MapScreen
import com.example.screen_map.MapViewModel
import com.example.screen_map.MarkerData
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.rememberCameraPositionState
import com.sryang.screen_filter.ui.Filter
import com.sryang.screen_filter.ui.FilterUiState
import com.sryang.screen_filter.ui.FilterViewModel
import com.sryang.torang_repository.api.ApiRestaurant
import com.sryang.torang_repository.data.remote.response.RemoteRestaurant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.launch
import kotlin.streams.toList


@InstallIn(SingletonComponent::class)
@Module
class FindingServiceModule {
    @Provides
    fun provideFindingService(apiRestaurant: ApiRestaurant): FindingService {
        return object : FindingService {
            override suspend fun findRestaurants(): List<RestaurantInfo> {
                return apiRestaurant.getAllRestaurant(HashMap()).stream().map {
                    it.toRestaurantInfo()
                }.toList()
            }

            override suspend fun filter(filter: com.example.screen_finding.finding.Filter): List<RestaurantInfo> {
                return apiRestaurant.getFilterRestaurant(
                    filter = filter.toFilter()
                )
                    .stream().map {
                        it.toRestaurantInfo()
                    }.toList()
            }
        }
    }
}

fun com.example.screen_finding.finding.Filter.toFilter(): com.sryang.torang_repository.data.Filter {
    return com.sryang.torang_repository.data.Filter(
        restaurantTypes = this.restaurantTypes?.stream()?.map { it.uppercase() }?.toList(),
        prices = this.prices,
        ratings = this.ratings?.toRating(),
        distances = this.distances?.toDistnace()
    )
}

fun String.toDistnace(): String? {
    if (this == "100m")
        return "_100M"
    else if (this == "200m")
        return "_200M"
    else if (this == "300m")
        return "_300M"
    else if (this == "1km")
        return "_1KM"
    else if (this == "3km")
        return "_3KM"
    return null
}

fun List<String>.toRating(): List<String>? {
    return this.stream().map {
        if (it == "*")
            "ONE"
        else if (it == "**")
            "TWO"
        else if (it == "***")
            "THREE"
        else if (it == "****")
            "FOUR"
        else if (it == "*****")
            "FIVE"
        else
            ""
    }.toList()
}

fun RemoteRestaurant.toRestaurantInfo(): RestaurantInfo {
    return RestaurantInfo(
        restaurantId = this.restaurantId,
        restaurantName = this.restaurantName,
        rating = this.rating,
        foodType = this.restaurantType,
        restaurantImage = this.imgUrl1,
        price = "$$$",
        distance = "120m",
        lat = this.lat,
        lon = this.lon,
    )
}

@Composable
fun Finding(
    findingViewModel: FindingViewModel = hiltViewModel(),
    restaurantCardViewModel: RestaurantCardViewModel = hiltViewModel(),
    filterViewModel: FilterViewModel = hiltViewModel(),
    mapViewModel: MapViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val uiState by findingViewModel.uiState.collectAsState()
    val cameraPositionState = rememberCameraPositionState()
    val coroutineScope = rememberCoroutineScope()
    var isMovingByMarkerClick by remember { mutableStateOf(false) }


    FindScreen(
        restaurantCardPage = {
            RestaurantCardPage(
                uiState = restaurantCardViewModel.uiState,
                restaurants = uiState.restaurants.stream().map { it.toRestaurantCardData() }
                    .toList(),
                restaurantImageUrl = "http://sarang628.iptime.org:89/restaurant_images/",
                onChangePage = { page ->
                    findingViewModel.selectPage(page)
                },
                onClickCard = { navController.navigate("restaurant/$it") },
                selectedRestaurant = uiState.selectedRestaurant?.toRestaurantCardData()
            )
        },
        mapScreen = {
            Box {
                MapScreen(
                    mapViewModel = mapViewModel,
                    onMark = {
                        isMovingByMarkerClick = true
                        findingViewModel.selectMarker(it)
                    },
                    onIdle = {
                        Log.d("MainActivity", "onIdle")
                        isMovingByMarkerClick = false
                    },
                    cameraPositionState = cameraPositionState,
                    list = uiState.restaurants.stream().map { it.toMarkData() }.toList(),
                    selectedMarkerData = uiState.selectedRestaurant?.toMarkData(),
                    currentLocation = uiState.currentLocation
                )
            }
        },
        onZoomIn = {
            coroutineScope.launch {
                cameraPositionState.animate(CameraUpdateFactory.zoomIn(), 300)
            }
        },
        onZoomOut = {
            coroutineScope.launch {
                cameraPositionState.animate(CameraUpdateFactory.zoomOut(), 300)
            }
        },
        filter = {
            Filter(filterViewModel = filterViewModel, onFilter = {
                findingViewModel.filter(it.toFilter())
            })
        },
        myLocation = {
            CurrentLocationScreen(onLocation = {
                findingViewModel.setCurrentLocation(it)
                coroutineScope.launch {
                    cameraPositionState.animate(
                        update = CameraUpdateFactory.newLatLng(
                            LatLng(
                                it.latitude,
                                it.longitude
                            )
                        ),
                        300
                    )
                }
            }
            )
        }
    )
}

fun RestaurantInfo.toRestaurantCardData(): RestaurantCardData {
    return RestaurantCardData(
        restaurantId = this.restaurantId,
        restaurantName = this.restaurantName,
        rating = this.rating,
        foodType = this.foodType,
        restaurantImage = this.restaurantImage,
        price = this.price,
        distance = this.distance
    )
}

fun RestaurantInfo.toMarkData(): MarkerData {
    return MarkerData(
        id = this.restaurantId,
        lat = this.lat,
        lon = this.lon,
        title = this.restaurantName,
        snippet = this.price,
        foodType = this.foodType
    )
}

fun FilterUiState.toFilter(): Filter {
    return com.example.screen_finding.finding.Filter(
        restaurantTypes = if (this.foodType.isEmpty()) null else foodType,
        prices = if (price.isEmpty()) null else price,
        ratings = if (rating.isEmpty()) null else rating,
        distances = distance
    )
}

private fun newLocation(): Location {
    val location = Location("MyLocationProvider")
    return location
}

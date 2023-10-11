package com.sryang.screenfindingtest.di.finding

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cardinfo.RestaurantCardData
import com.example.cardinfo.RestaurantCardPage
import com.example.cardinfo.RestaurantCardViewModel
import com.example.screen_finding.finding.FindScreen
import com.example.screen_finding.finding.FindingService
import com.example.screen_finding.finding.FindingViewModel
import com.example.screen_finding.finding.RestaurantInfo
import com.example.screen_map.MapScreen
import com.example.screen_map.MapViewModel
import com.example.screen_map.MarkerData
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.maps.android.compose.rememberCameraPositionState
import com.sryang.screen_filter.ui.Filter
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
        }
    }
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
    findingViewModel: FindingViewModel,
    restaurantCardViewModel: RestaurantCardViewModel,
    filterViewModel: FilterViewModel,
    mapViewModel: MapViewModel
) {
    val uiState by findingViewModel.uiState.collectAsState()
    val cameraPositionState = rememberCameraPositionState()
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    var isMovingByMarkerClick by remember { mutableStateOf(false) }
    NavHost(navController = navController, startDestination = "find") {
        composable("find") {
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
                        onClickCard = { navController.navigate("detail") },
                        selectedRestaurant = uiState.selectedRestaurant?.toRestaurantCardData()
                    )
                },
                mapScreen = {
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
                        selectedMarkerData = uiState.selectedRestaurant?.toMarkData()
                    )
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

                    })
                }
            )
        }
        composable("detail") {
            Text(text = "")
        }
    }
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
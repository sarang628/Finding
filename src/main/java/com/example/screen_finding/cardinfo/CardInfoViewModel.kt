package com.example.screen_finding.cardinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.torang_core.data.model.Restaurant
import com.example.torang_core.data.model.RestaurantData
import com.example.torang_core.repository.FindRepository
import com.example.torang_core.repository.MapRepository
import com.example.torang_core.util.Event
import com.example.torang_core.util.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CardInfoViewModel @Inject constructor(
    mapRepository: MapRepository,
    findRepository: FindRepository
) : ViewModel() {
    val currentPosition = MutableLiveData<Int>()
    val chooseRestaurant = MutableLiveData<Restaurant>()

    private val _clickCardInfo = MutableLiveData<Event<Restaurant>>()
    val clickCardInfo: LiveData<Event<Restaurant>> = _clickCardInfo

    val restaurants = findRepository.getSearchedRestaurant()

    val clickMap = mapRepository.getClickMap()

    fun clickRestaurant(restaurantData: Restaurant) {
        Logger.d("")
        _clickCardInfo.value = Event(restaurantData)
    }
}
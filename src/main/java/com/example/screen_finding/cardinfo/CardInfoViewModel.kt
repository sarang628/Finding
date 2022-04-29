package com.example.screen_finding.cardinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.torang_core.data.model.Restaurant
import com.example.torang_core.data.model.RestaurantData
import com.example.torang_core.util.Event
import com.example.torang_core.util.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CardInfoViewModel @Inject constructor() : ViewModel() {
    val currentPosition = MutableLiveData<Int>()
    val chooseRestaurant = MutableLiveData<Restaurant>()

    private val _clickCardInfo = MutableLiveData<Event<RestaurantData>>()
    val clickCardInfo: LiveData<Event<RestaurantData>> = _clickCardInfo

    fun clickRestaurant(restaurantData: RestaurantData) {
        Logger.d("")
        _clickCardInfo.value = Event(restaurantData)
    }
}
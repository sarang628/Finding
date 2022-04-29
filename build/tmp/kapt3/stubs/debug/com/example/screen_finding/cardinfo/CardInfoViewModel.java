package com.example.screen_finding.cardinfo;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/example/screen_finding/cardinfo/CardInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_clickCardInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/torang_core/util/Event;", "Lcom/example/torang_core/data/model/RestaurantData;", "chooseRestaurant", "Lcom/example/torang_core/data/model/Restaurant;", "getChooseRestaurant", "()Landroidx/lifecycle/MutableLiveData;", "clickCardInfo", "Landroidx/lifecycle/LiveData;", "getClickCardInfo", "()Landroidx/lifecycle/LiveData;", "currentPosition", "", "getCurrentPosition", "clickRestaurant", "", "restaurantData", "screen_finding_debug"})
public final class CardInfoViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> currentPosition = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.torang_core.data.model.Restaurant> chooseRestaurant = null;
    private final androidx.lifecycle.MutableLiveData<com.example.torang_core.util.Event<com.example.torang_core.data.model.RestaurantData>> _clickCardInfo = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.torang_core.util.Event<com.example.torang_core.data.model.RestaurantData>> clickCardInfo = null;
    
    @javax.inject.Inject()
    public CardInfoViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getCurrentPosition() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.torang_core.data.model.Restaurant> getChooseRestaurant() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.torang_core.util.Event<com.example.torang_core.data.model.RestaurantData>> getClickCardInfo() {
        return null;
    }
    
    public final void clickRestaurant(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.model.RestaurantData restaurantData) {
    }
}
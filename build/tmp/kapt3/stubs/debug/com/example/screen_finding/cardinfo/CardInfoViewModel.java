package com.example.screen_finding.cardinfo;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nR\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\rR\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001b0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/example/screen_finding/cardinfo/CardInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "mapRepository", "Lcom/example/torang_core/repository/MapRepository;", "findRepository", "Lcom/example/torang_core/repository/FindRepository;", "(Lcom/example/torang_core/repository/MapRepository;Lcom/example/torang_core/repository/FindRepository;)V", "_clickCardInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/torang_core/util/Event;", "Lcom/example/torang_core/data/model/Restaurant;", "chooseRestaurant", "getChooseRestaurant", "()Landroidx/lifecycle/MutableLiveData;", "clickCardInfo", "Landroidx/lifecycle/LiveData;", "getClickCardInfo", "()Landroidx/lifecycle/LiveData;", "clickMap", "Lkotlinx/coroutines/flow/Flow;", "", "getClickMap", "()Lkotlinx/coroutines/flow/Flow;", "currentPosition", "", "getCurrentPosition", "restaurants", "", "getRestaurants", "clickRestaurant", "", "restaurantData", "screen_finding_debug"})
public final class CardInfoViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> currentPosition = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.torang_core.data.model.Restaurant> chooseRestaurant = null;
    private final androidx.lifecycle.MutableLiveData<com.example.torang_core.util.Event<com.example.torang_core.data.model.Restaurant>> _clickCardInfo = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.torang_core.util.Event<com.example.torang_core.data.model.Restaurant>> clickCardInfo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.torang_core.data.model.Restaurant>> restaurants = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.lang.Boolean> clickMap = null;
    
    @javax.inject.Inject()
    public CardInfoViewModel(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.repository.MapRepository mapRepository, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.repository.FindRepository findRepository) {
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
    public final androidx.lifecycle.LiveData<com.example.torang_core.util.Event<com.example.torang_core.data.model.Restaurant>> getClickCardInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.torang_core.data.model.Restaurant>> getRestaurants() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getClickMap() {
        return null;
    }
    
    public final void clickRestaurant(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.model.Restaurant restaurantData) {
    }
}
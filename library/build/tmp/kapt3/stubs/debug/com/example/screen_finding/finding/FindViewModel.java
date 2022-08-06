package com.example.screen_finding.finding;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J1\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0011\u0010!\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/example/screen_finding/finding/FindViewModel;", "Landroidx/lifecycle/ViewModel;", "searchRepository", "Lcom/example/torang_core/repository/SearchRepository;", "findingRepository", "Lcom/example/torang_core/repository/FindRepository;", "filterRepository", "Lcom/example/torang_core/repository/FilterRepository;", "mapRepository", "Lcom/example/torang_core/repository/MapRepository;", "nationRepository", "Lcom/example/torang_core/repository/NationRepository;", "(Lcom/example/torang_core/repository/SearchRepository;Lcom/example/torang_core/repository/FindRepository;Lcom/example/torang_core/repository/FilterRepository;Lcom/example/torang_core/repository/MapRepository;Lcom/example/torang_core/repository/NationRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/screen_finding/finding/FindUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "permissionGranated", "", "requestLocation", "search", "keyword", "", "searchBoundRestaurant", "northEastLatitude", "", "northEastLongitude", "southWestLatitude", "southWestLongitude", "(DDDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subScribe", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "library_debug"})
public final class FindViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.torang_core.repository.SearchRepository searchRepository = null;
    private final com.example.torang_core.repository.FindRepository findingRepository = null;
    private final com.example.torang_core.repository.FilterRepository filterRepository = null;
    private final com.example.torang_core.repository.MapRepository mapRepository = null;
    private final com.example.torang_core.repository.NationRepository nationRepository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.screen_finding.finding.FindUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.screen_finding.finding.FindUiState> uiState = null;
    
    @javax.inject.Inject()
    public FindViewModel(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.repository.SearchRepository searchRepository, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.repository.FindRepository findingRepository, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.repository.FilterRepository filterRepository, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.repository.MapRepository mapRepository, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.repository.NationRepository nationRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.screen_finding.finding.FindUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.InternalCoroutinesApi.class})
    public final java.lang.Object subScribe(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object searchBoundRestaurant(double northEastLatitude, double northEastLongitude, double southWestLatitude, double southWestLongitude, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final void requestLocation() {
    }
    
    public final void search(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword) {
    }
    
    public final void permissionGranated() {
    }
}
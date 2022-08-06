package com.example.screen_finding.finding;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/example/screen_finding/finding/TestFindViewModel;", "Landroidx/lifecycle/ViewModel;", "searchRepository", "Lcom/example/torang_core/repository/SearchRepository;", "findingRepository", "Lcom/example/torang_core/repository/FindRepository;", "(Lcom/example/torang_core/repository/SearchRepository;Lcom/example/torang_core/repository/FindRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/screen_finding/finding/FindUiState;", "isFocusSearchView", "Landroidx/lifecycle/MutableLiveData;", "", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "onReceiveLocation", "", "requestLocation", "search", "keyword", "", "setIsFocusSearchView", "library_debug"})
public final class TestFindViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.torang_core.repository.SearchRepository searchRepository = null;
    private final com.example.torang_core.repository.FindRepository findingRepository = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isFocusSearchView = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.screen_finding.finding.FindUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.screen_finding.finding.FindUiState> uiState = null;
    
    @javax.inject.Inject()
    public TestFindViewModel(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.repository.SearchRepository searchRepository, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.repository.FindRepository findingRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.screen_finding.finding.FindUiState> getUiState() {
        return null;
    }
    
    public final void setIsFocusSearchView(boolean isFocusSearchView) {
    }
    
    public final void search(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword) {
    }
    
    public final void requestLocation() {
    }
    
    public final void onReceiveLocation() {
    }
}
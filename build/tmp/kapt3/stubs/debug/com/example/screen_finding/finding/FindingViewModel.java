package com.example.screen_finding.finding;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/screen_finding/finding/FindingViewModel;", "Landroidx/lifecycle/ViewModel;", "searchRepository", "Lcom/example/torang_core/repository/SearchRepository;", "findingRepository", "Lcom/example/torang_core/repository/FindRepository;", "(Lcom/example/torang_core/repository/SearchRepository;Lcom/example/torang_core/repository/FindRepository;)V", "isFocusSearchView", "Landroidx/lifecycle/MutableLiveData;", "", "search", "", "keyword", "", "setIsFocusSearchView", "screen_finding_debug"})
public final class FindingViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.torang_core.repository.SearchRepository searchRepository = null;
    private final com.example.torang_core.repository.FindRepository findingRepository = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isFocusSearchView = null;
    
    public FindingViewModel(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.repository.SearchRepository searchRepository, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.repository.FindRepository findingRepository) {
        super();
    }
    
    public final void setIsFocusSearchView(boolean isFocusSearchView) {
    }
    
    public final void search(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword) {
    }
}
package com.example.screen_finding.finding;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/screen_finding/finding/FindingViewModel;", "Landroidx/lifecycle/ViewModel;", "searchRepository", "Lcom/example/torang_core/repository/SearchRepository;", "(Lcom/example/torang_core/repository/SearchRepository;)V", "isFocusSearchView", "Landroidx/lifecycle/MutableLiveData;", "", "search", "", "keyword", "", "setIsFocusSearchView", "screen_finding_debug"})
public final class FindingViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.torang_core.repository.SearchRepository searchRepository = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isFocusSearchView = null;
    
    public FindingViewModel(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.repository.SearchRepository searchRepository) {
        super();
    }
    
    public final void setIsFocusSearchView(boolean isFocusSearchView) {
    }
    
    public final void search(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword) {
    }
}
package com.example.screen_finding.finding;

import java.lang.System;

/**
 * 맛집 찾기 화면
 * [FindingFragmentBinding]
 * [FindUiState]
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0002J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u0012H\u0002J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010$\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\'"}, d2 = {"Lcom/example/screen_finding/finding/FindFragment;", "Landroidx/fragment/app/Fragment;", "()V", "locationPermissionContract", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "viewModel", "Lcom/example/screen_finding/finding/FindViewModel;", "getViewModel", "()Lcom/example/screen_finding/finding/FindViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "changeStateButton", "", "btn", "Lcom/google/android/material/floatingactionbutton/ExtendedFloatingActionButton;", "b", "", "gpsOff", "show", "initEvent", "binding", "Lcom/example/screen_finding/databinding/FindingFragmentBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "requestPermission1", "showLocationDialog", "showNeedPermissionPopup", "subscribeUI", "updateUI", "uiState", "Lcom/example/screen_finding/finding/FindUiState;", "library_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class FindFragment extends androidx.fragment.app.Fragment {
    private final kotlin.Lazy viewModel$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> locationPermissionContract = null;
    
    public FindFragment() {
        super();
    }
    
    private final com.example.screen_finding.finding.FindViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    /**
     * 이벤트 초기화
     */
    private final void initEvent(com.example.screen_finding.databinding.FindingFragmentBinding binding) {
    }
    
    /**
     * UI 구독
     */
    private final void subscribeUI(com.example.screen_finding.databinding.FindingFragmentBinding binding) {
    }
    
    /**
     * 위치 검색 중 버튼 확장 축소
     */
    private final void changeStateButton(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton btn, boolean b) {
    }
    
    /**
     * UI 업데이트
     */
    private final void updateUI(com.example.screen_finding.databinding.FindingFragmentBinding binding, com.example.screen_finding.finding.FindUiState uiState) {
    }
    
    private final void showNeedPermissionPopup(boolean showNeedPermissionPopup) {
    }
    
    private final void gpsOff(boolean show) {
    }
    
    /**
     * 위치 권한 요청 다이얼로그
     */
    private final void showLocationDialog(boolean b) {
    }
    
    private final void requestPermission1() {
    }
}
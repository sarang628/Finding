package com.example.screen_finding.cardinfo;

import java.lang.System;

/**
 * [FragmentViewPagerBinding]
 * [CardInfoVp2Adt]
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006)"}, d2 = {"Lcom/example/screen_finding/cardinfo/CardInfoFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/example/screen_finding/cardinfo/CardInfoVp2Adt;", "mViewModel", "Lcom/example/screen_finding/cardinfo/CardInfoViewModel;", "getMViewModel", "()Lcom/example/screen_finding/cardinfo/CardInfoViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "previousState", "", "getPreviousState", "()I", "setPreviousState", "(I)V", "restaurantDetailNavigation", "Lcom/example/torang_core/navigation/RestaurantDetailNavigation;", "getRestaurantDetailNavigation", "()Lcom/example/torang_core/navigation/RestaurantDetailNavigation;", "setRestaurantDetailNavigation", "(Lcom/example/torang_core/navigation/RestaurantDetailNavigation;)V", "userScrollChange", "", "getUserScrollChange", "()Z", "setUserScrollChange", "(Z)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "subScribeUi", "", "binding", "Lcom/example/screen_finding/databinding/FragmentViewPagerBinding;", "screen_finding_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class CardInfoFragment extends androidx.fragment.app.Fragment {
    private int previousState = 0;
    private boolean userScrollChange = false;
    private final kotlin.Lazy mViewModel$delegate = null;
    
    /**
     * 카드정보 뷰페이저 아답터
     */
    private com.example.screen_finding.cardinfo.CardInfoVp2Adt adapter;
    @javax.inject.Inject()
    public com.example.torang_core.navigation.RestaurantDetailNavigation restaurantDetailNavigation;
    
    public CardInfoFragment() {
        super();
    }
    
    public final int getPreviousState() {
        return 0;
    }
    
    public final void setPreviousState(int p0) {
    }
    
    public final boolean getUserScrollChange() {
        return false;
    }
    
    public final void setUserScrollChange(boolean p0) {
    }
    
    private final com.example.screen_finding.cardinfo.CardInfoViewModel getMViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.torang_core.navigation.RestaurantDetailNavigation getRestaurantDetailNavigation() {
        return null;
    }
    
    public final void setRestaurantDetailNavigation(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.navigation.RestaurantDetailNavigation p0) {
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
     * UI 구독
     */
    private final void subScribeUi(com.example.screen_finding.databinding.FragmentViewPagerBinding binding) {
    }
}
package com.example.screen_finding.cardinfo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J&\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0014\u0010\u0015\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/screen_finding/cardinfo/CardInfoVpAdt;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "restaurants", "", "Lcom/example/torang_core/data/model/Restaurant;", "clickRestaurant", "", "restaurant", "createFragment", "position", "", "getItemCount", "onBindViewHolder", "holder", "Landroidx/viewpager2/adapter/FragmentViewHolder;", "payloads", "", "", "setRestaurants", "screen_finding_debug"})
public abstract class CardInfoVpAdt extends androidx.viewpager2.adapter.FragmentStateAdapter {
    private java.util.List<com.example.torang_core.data.model.Restaurant> restaurants;
    
    public CardInfoVpAdt(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment) {
        super(null);
    }
    
    public abstract void clickRestaurant(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.model.Restaurant restaurant);
    
    public final void setRestaurants(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.torang_core.data.model.Restaurant> restaurants) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.fragment.app.Fragment createFragment(int position) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.viewpager2.adapter.FragmentViewHolder holder, int position, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Object> payloads) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
}
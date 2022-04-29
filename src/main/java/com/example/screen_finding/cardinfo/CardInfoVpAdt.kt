package com.example.screen_finding.cardinfo

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.example.torang_core.data.model.RestaurantData


abstract class CardInfoVpAdt(fragment: Fragment) : FragmentStateAdapter(fragment) {
    abstract fun clickRestaurant(restaurant: RestaurantData)
    private var restaurants: List<RestaurantData> = ArrayList()
    fun setRestaurants(restaurants: List<RestaurantData>) {
        this.restaurants = restaurants
        notifyDataSetChanged()
    }

    override fun createFragment(position: Int): Fragment {
        val torangCardVpItem = CardInfoItem()
        torangCardVpItem.setRestaurant(restaurants[position])
        torangCardVpItem.setOnClickListener { view: View? ->
            clickRestaurant(
                restaurants[position]
            )
        }
        return torangCardVpItem
    }

    override fun onBindViewHolder(
        holder: FragmentViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }
}
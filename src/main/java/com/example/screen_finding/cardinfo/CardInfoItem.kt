package com.example.screen_finding.cardinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.screen_finding.databinding.FragmentTorangCardVpItemBinding
import com.example.torang_core.data.model.RestaurantData

/**
 * A simple [Fragment] subclass.
 */
class CardInfoItem : Fragment() {

    var binding: FragmentTorangCardVpItemBinding? = null

    private var restaurant: RestaurantData? = null
    private var onClickListener: View.OnClickListener? = null
    fun setOnClickListener(onClickListener: View.OnClickListener?) {
        this.onClickListener = onClickListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTorangCardVpItemBinding.inflate(layoutInflater, container, false)
        binding?.lifecycleOwner = this
        /*val picRvAdt: PicRvAdt = object : PicRvAdt() {
            public override fun clickPicture() {
                if (onClickListener != null) onClickListener!!.onClick(null)
            }
        }*/
        //picRvAdt.setRestaurant(restaurant)
        //binding?.recyclerView?.adapter = picRvAdt;
        if (restaurant != null)
            if (onClickListener != null) binding?.container?.setOnClickListener(
                onClickListener
            )
        return binding!!.root
    }

    fun setRestaurant(restaurant: RestaurantData?) {
        this.restaurant = restaurant
    }

    override fun onResume() {
        super.onResume()
        binding?.restaurant = restaurant
    }
}
package com.example.screen_finding.cardinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.screen_finding.databinding.FragmentViewPagerBinding
import com.example.torang_core.navigation.RestaurantDetailNavigation
import com.example.torang_core.util.EventObserver
import com.example.torang_core.util.Logger
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * [FragmentViewPagerBinding]
 * [CardInfoVp2Adt]
 */
@AndroidEntryPoint
class CardInfoFragment : Fragment() {
    var previousState: Int = 0
    var userScrollChange: Boolean = false
    private val mViewModel: CardInfoViewModel by viewModels()

    /** 공유 뷰모델 */
    //private val mapSharedViewModel: MapSharedViewModel by activityViewModels()

    /** 카드정보 뷰페이저 아답터 */
    private lateinit var adapter: CardInfoVp2Adt

    @Inject
    lateinit var restaurantDetailNavigation: RestaurantDetailNavigation


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 페이지 아답터 초기화
        adapter = CardInfoVp2Adt(mViewModel, viewLifecycleOwner)

        // 바인딩 초기화
        val binding = FragmentViewPagerBinding.inflate(layoutInflater, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner

                // 뷰페이저 설정
                vp.apply {
                    clipToPadding = false
                    setPageTransformer(MarginPageTransformer(50))
                    adapter = this@CardInfoFragment.adapter
                }

                // 뷰페이저 페이지 리스너 설정
                vp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        Logger.d(position)
                        //mapSharedViewModel.selectPosition(position)
                        Logger.v("userScrollChange : $userScrollChange")
                        //if (userScrollChange)
                            //mapSharedViewModel.selectPosition(position)
                    }

                    override fun onPageScrollStateChanged(state: Int) {
                        super.onPageScrollStateChanged(state)
                        if (previousState == ViewPager.SCROLL_STATE_DRAGGING && state == ViewPager.SCROLL_STATE_SETTLING)
                            userScrollChange = true;
                        else if (previousState == ViewPager.SCROLL_STATE_SETTLING && state == ViewPager.SCROLL_STATE_IDLE)
                            userScrollChange = false;
                        previousState = state;
                    }

                    override fun onPageScrolled(
                        position: Int,
                        positionOffset: Float,
                        positionOffsetPixels: Int
                    ) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                        if (position == 0 && positionOffsetPixels == 0) {

                        } else {
                            //mapSharedViewModel.isMoved = false
                        }
                    }
                })
            }

        subScribeUi(binding)

        return binding.root
    }

    /**
     * UI 구독
     */
    private fun subScribeUi(binding: FragmentViewPagerBinding) {
        // 레스토랑 리스트 감지
        /*mapSharedViewModel.restaurants.observe(viewLifecycleOwner, {
            adapter.setRestaurants(it)
        })*/
        /*mapSharedViewModel.isExpended.observe(viewLifecycleOwner) {

            val animation = AnimationUtils.loadAnimation(
                context, if (it) R.anim.slide_card_up else R.anim.slide_card_down
            )
            binding.vp.startAnimation(animation)
            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {
                    if (!it) binding.vp.visibility = View.VISIBLE
                }

                override fun onAnimationEnd(animation: Animation) {
                    if (it) binding.vp.visibility = View.INVISIBLE
                }

                override fun onAnimationRepeat(animation: Animation) {}
            })
        }*/

        /*mapSharedViewModel.currentRestaurantPosition.observe(viewLifecycleOwner, {
            it?.let {
                if (binding.vp.currentItem != it) {
                    binding.vp.post {
                        binding.vp.setCurrentItem(it, true)
                    }
                }
            }
        })*/

        mViewModel.clickCardInfo.observe(viewLifecycleOwner, EventObserver {
            val mode = requireActivity().intent.getIntExtra("mode", 0)
            Logger.d("click restaurant $it")
            if (mode == 0) {
                restaurantDetailNavigation.go(requireContext(), it.restaurant_id)
            } else {
                //mapSharedViewModel.selectRestaurant(it)
                requireActivity().onBackPressed()
            }
        })
    }
}
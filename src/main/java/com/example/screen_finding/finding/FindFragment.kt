package com.example.screen_finding.finding

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.screen_finding.R
import com.example.screen_finding.databinding.FindingFragmentBinding
import com.example.screen_map.MapSharedViewModel
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * [FindingFragmentBinding]
 */
@AndroidEntryPoint
class FindFragment : Fragment() {
    /** 공유 뷰모델 */
    private val mapSharedViewModel: MapSharedViewModel by activityViewModels()
    private val viewModel: FindingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FindingFragmentBinding.inflate(layoutInflater, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner

                svMap.setOnClickListener {
                    val navController = findNavController()
                    navController.navigate(R.id.action_findFragment_to_searchFragment)
                }

                tvKeyword.setOnClickListener {
                    val navController = findNavController()
                    navController.navigate(R.id.action_findFragment_to_searchFragment)
                }

                lifecycleScope.launch {
                    repeatOnLifecycle(Lifecycle.State.RESUMED) {
                        // 위치 검색중 상태 변경
                        viewModel.uiState.collect {
                            changeStateButton(toggleBtn, it.isRequestingLocation)
                        }
                    }
                }

            }

        mapSharedViewModel.errorMsg.observe(viewLifecycleOwner) {
            AlertDialog.Builder(requireContext())
                .setMessage(it)
                .show()
        }
        return binding.root
    }

    /**
     * 위치 검색 중 버튼 확장 축소
     */
    private fun changeStateButton(btn: ExtendedFloatingActionButton, b: Boolean) {
        if (b) {
            btn.shrink()
        } else {
            btn.text = "Loading"
            btn.extend()
        }
    }
}
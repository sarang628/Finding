package com.example.screen_finding.finding

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.screen_finding.R
import com.example.screen_finding.databinding.FindingFragmentBinding
import com.example.screen_map.MapSharedViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * [FindingFragmentBinding]
 */
@AndroidEntryPoint
class FindFragment : Fragment() {
    /** 공유 뷰모델 */
    private val mapSharedViewModel: MapSharedViewModel by activityViewModels()

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
            }

        mapSharedViewModel.errorMsg.observe(viewLifecycleOwner) {
            AlertDialog.Builder(requireContext())
                .setMessage(it)
                .show()
        }
        return binding.root
    }
}
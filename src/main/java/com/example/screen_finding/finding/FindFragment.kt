package com.example.screen_finding.finding

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.screen_finding.R
import com.example.screen_finding.databinding.FindingFragmentBinding
import com.example.torang_core.util.Logger
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * 맛집 찾기 화면
 * [FindingFragmentBinding]
 * [FindUiState]
 */
@AndroidEntryPoint
class FindFragment : Fragment() {
    private val viewModel: FindViewModel by viewModels()

    private val requestPermissionLauncher1 =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            it.get(Manifest.permission.ACCESS_COARSE_LOCATION)?.let {
                if (it)
                    viewModel.permissionGranated()
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 바인딩 초기화
        val binding = FindingFragmentBinding.inflate(layoutInflater, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
            }

        // UI 구독
        subscribeUI(binding)

        // 이벤트 초기화
        initEvent(binding)

        return binding.root
    }

    /**
     * 이벤트 초기화
     */
    private fun initEvent(binding: FindingFragmentBinding) {
        binding.apply {
            //검색 영역 클릭 시 이동
            svMap.setOnClickListener {
                val navController = findNavController()
                navController.navigate(R.id.action_findFragment_to_searchFragment)
            }

            //검색 영역 클릭 시 이동
            tvKeyword.setOnClickListener {
                val navController = findNavController()
                navController.navigate(R.id.action_findFragment_to_searchFragment)
            }

            // 내위치 요청 클릭
            toggleBtn.setOnClickListener {
                viewModel.requestLocation()
            }
        }
    }

    /**
     * UI 구독
     */
    private fun subscribeUI(binding: FindingFragmentBinding) {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                // 위치 검색중 상태 변경
                /**[FindUiState]*/
                viewModel.uiState.collect {
                    updateUI(binding, it)
                }
            }
        }
    }

    /**
     * 위치 검색 중 버튼 확장 축소
     */
    private fun changeStateButton(btn: ExtendedFloatingActionButton, b: Boolean) {
        if (!b) {
            btn.shrink()
        } else {
            btn.text = getString(R.string.loading)
            btn.extend()
        }
    }

    /**
     * UI 업데이트
     */
    private fun updateUI(binding: FindingFragmentBinding, uiState: FindUiState) {
        binding.uiState = uiState
        changeStateButton(binding.toggleBtn, uiState.isRequestingLocation)
        showLocationDialog(uiState.showLocationPermissionDialogPopup)
        if (uiState.showLocationSystemPermission) {
            requestPermission1()
        }
        showNeedPermissionPopup(uiState.showNeedPermissionPopup)
        gpsOff(uiState.gpsOff)
    }

    private fun showNeedPermissionPopup(showNeedPermissionPopup: Boolean) {
        if (!showNeedPermissionPopup)
            return

        AlertDialog.Builder(requireContext())
            .setMessage("위치권한이 필요합니다. 권한 설정화면으로 이동하시겠습니까?")
            .setPositiveButton("예") { _, _ ->
                val intent = Intent(
                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.fromParts("package", requireContext().getPackageName(), null)
                )
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
            .show()
    }

    private fun gpsOff(show: Boolean) {
        if (!show)
            return

        AlertDialog.Builder(requireContext())
            .setMessage("GPS가 꺼져있습니다. 설정화면으로 이동하시겠습니까?")
            .setPositiveButton("예") { _, _ ->
                startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
            .show()
    }

    /**
     * 위치 권한 요청 다이얼로그
     */
    private fun showLocationDialog(b: Boolean) {
        if (!b)
            return

        AlertDialog.Builder(requireContext())
            .setCancelable(false)
            .setMessage("지도 검색 기능을 사용하기위해서는 위치권한을 필요로 합니다. 위치권한을 허용하시겠습니까?")
            .setPositiveButton("예") { _, _ ->
                requestPermission1()
            }
            .setNegativeButton("아니오") { _, _ ->
            }
            .setOnDismissListener {
            }
            .show()
    }

    private fun requestPermission1() {
        when {
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED -> {
                // You can use the API that requires the permission.
            }
            shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION)
            -> {
                // In an educational UI, explain to the user why your app requires this
                // permission for a specific feature to behave as expected. In this UI,
                // include a "cancel" or "no thanks" button that allows the user to
                // continue using your app without granting the permission.
                //showInContextUI(...)
            }
            else -> {
                // You can directly ask for the permission.
                // The registered ActivityResultCallback gets the result of this request.
                requestPermissionLauncher1.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )

                )
            }
        }
    }
}
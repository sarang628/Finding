package com.sryang.screenfindingtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cardinfo.testRestaurantInfoCardUiState
import com.example.screen_finding.finding.FindScreen
import com.example.screen_finding.finding.TextFindScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val d = testRestaurantInfoCardUiState(this)
        setContent {
            TextFindScreen()
        }
    }
}
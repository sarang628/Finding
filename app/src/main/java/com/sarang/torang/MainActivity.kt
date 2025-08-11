package com.sarang.torang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sarang.torang.di.finding_di.FindingWithPermission
import com.sryang.library.compose.workflow.BestPracticeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "finding") {
                composable("finding") {
                    val navController = RootNavController()
                    //FindingWithPermission(navController = navController, viewModel = BestPracticeViewModel())
                }
                composable("restaurant/{restaurantId}") {
                    Text(text = "")
                }
            }
        }
    }
}
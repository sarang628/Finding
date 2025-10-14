package com.sarang.torang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sarang.torang.di.finding_di.findingWithPermission
import com.sarang.torang.di.restaurant_list_bottom_sheet_di.CustomRestaurantItemImageLoader
import com.sryang.library.compose.workflow.BestPracticeViewModel
import com.sryang.torang.ui.TorangTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TorangTheme {
                Surface(color = MaterialTheme.colorScheme.background){
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "finding") {
                        composable("finding") {
                            CompositionLocalProvider(LocalRestaurantItemImageLoader provides CustomRestaurantItemImageLoader) {
                                Box {
                                    findingWithPermission(
                                        viewModel = BestPracticeViewModel()
                                    ).invoke()
                                }
                            }
                        }
                        composable("restaurant/{restaurantId}") {
                            Text(text = "")
                        }
                    }
                }
            }
        }
    }
}
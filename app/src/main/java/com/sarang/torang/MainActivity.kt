package com.sarang.torang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sarang.torang.di.finding_di.findingWithPermission
import com.sryang.library.compose.workflow.BestPracticeViewModel
import com.sryang.torang.ui.TorangTheme
import dagger.hilt.android.AndroidEntryPoint
import com.sarang.torang.di.restaurant_list_bottom_sheet_di.CustomRestaurantItemImageLoader
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TorangTheme {
                Surface(color = MaterialTheme.colorScheme.background){
                    val navController = rememberNavController()
                    val scaffoldState: BottomSheetScaffoldState = rememberBottomSheetScaffoldState()
                    val coroutine = rememberCoroutineScope()
                    NavHost(navController = navController, startDestination = "finding") {
                        composable("finding") {
                            val navController = RootNavController()
                            CompositionLocalProvider(LocalRestaurantItemImageLoader provides CustomRestaurantItemImageLoader){
                                Scaffold(floatingActionButton = {
                                    FloatingActionButton({coroutine.launch { scaffoldState.bottomSheetState.expand() }}) { Icon(Icons.AutoMirrored.Default.List, "") }
                                }) {
                                    Box(Modifier.padding(it)){
                                        RestaurantListBottomSheet(
                                            scaffoldState = scaffoldState,
                                            sheetPeekHeight = 0.dp,
                                            modifier = Modifier.fillMaxSize()
                                        ) {
                                            findingWithPermission(navController = navController, viewModel = BestPracticeViewModel())
                                        }
                                    }
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
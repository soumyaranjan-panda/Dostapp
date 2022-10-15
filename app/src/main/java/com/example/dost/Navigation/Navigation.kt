package com.example.dost.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgumentBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dost.Screens.DetailsView
import com.example.dost.Screens.HomeScreen
import com.example.dost.Screens.SplashScreen
import com.example.dost.viewModels.HomeViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val viewModel = HomeViewModel()
    NavHost(navController, startDestination = "splash") {
        composable(route = "splash") {
            SplashScreen(navController)
        }
        composable(route = "home") {
            HomeScreen(viewModel,navController)
        }
        composable(route = "detail") {
            DetailsView(viewModel,navController)
        }
    }
}

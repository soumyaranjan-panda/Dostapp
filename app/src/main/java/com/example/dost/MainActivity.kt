package com.example.dost

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dost.Navigation.Navigation
import com.example.dost.Screens.DetailsView
import com.example.dost.Screens.HomeScreen
import com.example.dost.ui.theme.DostTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DostTheme {
                Navigation()
            }
        }
    }
}
// @Composable
// fun MyApp(){
// val navController = rememberNavController()
//
// NavHost(navController = navController, startDestination = "home" ){
// composable(route = "home"){
// HomeScreen(navController)
// }
// composable(route = "details/{dogIndex}", arguments = listOf(navArgument("dogIndex"){type = NavType.IntType})){
// val dogIndex: Int = it.arguments?.getInt("dogIndex")?: 0
// DetailsView(id = dogIndex)
// }
// }
// }
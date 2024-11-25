package com.example.tienda

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SupermarketApp(){
    val navController = rememberNavController()
    val viewModel: SupermarketViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "product_screen"
    ){
        composable("product_screen"){
            ProductScreen(navController, viewModel)
        }
        composable("cart_screen"){
            CartScreen(navController, viewModel)
        }
    }
}
















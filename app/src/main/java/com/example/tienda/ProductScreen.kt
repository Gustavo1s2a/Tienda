package com.example.tienda

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun ProductScreen(navController: NavHostController, viewModel: SupermarketViewModel){
    val products = listOf(
        Product("Apple", 1.0),
        Product("Banana", 0.5),
        Product("Orange", 0.75),
        Product("Grapes", 2.5),
        Product("Mango", 1.8)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(
            text = "Avalible Products",
            fontSize = 22.sp,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally)
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ){
            items(products) { product ->
                ProductCard(
                    product = product,
                    onClick = { viewModel.addItem(product)}
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("cart_screen")},
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
        ){
            Text(text = "Go to Cart", fontSize = 16.sp)
        }
    }
}























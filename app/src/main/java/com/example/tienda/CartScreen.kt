package com.example.tienda
import com.example.tienda.CartUIComponents
import com.example.tienda.CartUIComponents.CartTitle
import com.example.tienda.CartUIComponents.CartTotal
import com.example.tienda.CartItemComponents.CartRow


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tienda.CartUIComponents.BackToProductsButton
import com.example.tienda.CartItemComponents.CartItemList


@Composable
fun CartScreen(navController: NavHostController, viewModel: SupermarketViewModel){
    val cartItems = viewModel.cartItems
    val total = viewModel.total

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ){
            CartTitle()
            CartItemList(
                cartItems = cartItems,
                onRemove = { viewModel.removeItem(it) }
            )
            CartTotal(total = total)
        }

        BackToProductsButton(navController = navController)
    }
}


















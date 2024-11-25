package com.example.tienda

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.navigation.NavHostController

/**
 * Clase contenedora para componentes relacionados con el carrito.
 */
object CartUIComponents {

    @Composable
    fun CartTitle() {
        Text(
            text = "Your Cart",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }

    @Composable
    fun CartTotal(total: Double) {
        Text(
            text = "Total: $${total.format(2)}",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(end = 8.dp)
        )
    }
    @Composable
    fun BackToProductsButton(navController: NavHostController) {
        Button(
            onClick = { navController.navigate("product_screen") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text("Back to Products", color = Color.White, fontWeight = FontWeight.Medium)

        }
    }
}
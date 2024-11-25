package com.example.tienda

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun CartItemView(item: CartItem, onRemove: () -> Unit){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "${item.name} x${item.quantity} - $${item.totalPrice.format(2)}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )

        Button(onClick = onRemove){
            Text("Remove")
        }
    }
}
























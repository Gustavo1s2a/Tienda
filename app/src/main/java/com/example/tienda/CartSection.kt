package com.example.tienda

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CartSection(
    cartItems: List<CartItem>,
    total: Double,
    onRemove: (CartItem) -> Unit,
    onClearCart: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(
            text = "Your Cart",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        if (cartItems.isEmpty()){
            Text(
                text = "Your cart is empty",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                items(cartItems){ item ->
                    CartItemCard(item = item,onRemove = onRemove)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Total: $${total.format(2)}",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.align(Alignment.End)
            )

            Button(
                onClick = onClearCart,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                    shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ){
                Text(text = "Clear Cart", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun CartItemCard(item: CartItem, onRemove: (CartItem) -> Unit){
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Column{
                Text(
                    text = item.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "x${item.quantity} - $${item.totalPrice.format(2)}",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
            }

            Button(
                onClick = { onRemove(item ) },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ){
                Text("Remove", color = Color.White, fontSize = 14.sp)
            }
        }
    }
}





























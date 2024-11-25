package com.example.tienda

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

class SupermarketViewModel : ViewModel(){
    val cartItems: SnapshotStateList<CartItem> = mutableStateListOf()

    val total: Double
        get() = cartItems.sumOf { it.totalPrice }

    fun addItem(product: Product){
        val existingItem = cartItems.find { it.name == product.name }
        if (existingItem != null){
            existingItem.quantity++
            existingItem.totalPrice += product.price
        } else {
            cartItems.add(CartItem(product.name, 1, product.price))
        }
    }

    fun removeItem(item: CartItem){
        if (item.quantity > 1){
            item.quantity--
            item.totalPrice -= item.totalPrice / (item.quantity + 1)
        } else {
            cartItems.remove(item)
        }
    }

    fun clearCart(){
        cartItems.clear()
    }

}




























package com.example.tienda

data class Product(val name: String, val price: Double)
data class CartItem(
    val name: String,
    var quantity: Int,
    var totalPrice: Double
)

fun Double.format(digits: Int) = String.format("%.${digits}f", this)
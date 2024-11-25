package com.example.tienda

fun addItemToCart(product: Product, cartItems: MutableList<CartItem>, updateTotal: (Double) -> Unit){
    val existingItem = cartItems.find { it.name == product.name }
    if (existingItem != null){
        existingItem.quantity += 1
        existingItem.totalPrice = existingItem.quantity * product.price
    } else {
        cartItems.add(CartItem(product.name, 1, product.price))
    }

    updateTotal(product.price)
}


fun removeItemFromCart(item: CartItem, cartItems: MutableList<CartItem>, updateTotal: (Double) -> Unit){
    if (item.quantity > 1){
        val unitPrice = item.totalPrice
        item.quantity -= 1
        item.totalPrice = item.quantity * unitPrice
        updateTotal(-unitPrice)
    } else {
        updateTotal(-item.totalPrice)
        cartItems.remove(item)
    }
}
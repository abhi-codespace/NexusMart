package com.nexusmart.nexusmart_backend.serviceInterface;

import java.util.List;

import com.nexusmart.nexusmart_backend.entity.CartItem;

public interface CartItemService {

    List<CartItem> getAllCartItems();

    CartItem getCartItemById(Long id);

    CartItem createCartItem(CartItem cartItem);

    CartItem updateCartItem(Long id,CartItem cartItem);

    void deleteCartItem(Long id);
}

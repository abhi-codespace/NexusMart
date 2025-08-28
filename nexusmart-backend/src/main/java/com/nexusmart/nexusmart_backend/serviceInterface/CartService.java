package com.nexusmart.nexusmart_backend.serviceInterface;

import java.util.List;

import com.nexusmart.nexusmart_backend.entity.Cart;

public interface CartService {

    List<Cart> getAllCarts();

    Cart getCartById(Long id);

    Cart createCart(Cart cart);

    Cart updateCart(Long id,Cart cart);

    void deleteCart(Long id);
}

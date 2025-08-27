package com.nexusmart.nexusmart_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nexusmart.nexusmart_backend.entity.CartItem;
import com.nexusmart.nexusmart_backend.repository.CartItemRepository;
import com.nexusmart.nexusmart_backend.serviceInterface.CartItemService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    //interface function

    // List<CartItem> getAllCartItems();

    // CartItem getCartItemById(Long id);

    // CartItem createCartItem(CartItem cartItem);

    // CartItem updateCartItem(Long id,CartItem cartItem);

    // CartItem deleteCartItem(Long id);

    //getting all CartItem data from datebase


    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem getCartItemById(Long id) {
        return cartItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CartItem not found with id: " + id));
    }

    @Override
    public CartItem createCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem updateCartItem(Long id, CartItem cartItem) {
        return cartItemRepository.findById(id)
                .map(existingItem -> {
                    existingItem.setQuantity(cartItem.getQuantity());
                    existingItem.setProduct(cartItem.getProduct());
                    existingItem.setUser(cartItem.getUser());
                    return cartItemRepository.save(existingItem);
                })
                .orElse(null);
    }

    @Override
    public void deleteCartItem(Long id) {
        if (!cartItemRepository.existsById(id)) {
            throw new RuntimeException("CartItem not found with id: " + id);
        }
        cartItemRepository.deleteById(id);
    }
}


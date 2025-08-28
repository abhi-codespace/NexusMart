package com.nexusmart.nexusmart_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nexusmart.nexusmart_backend.entity.Cart;
import com.nexusmart.nexusmart_backend.repository.CartRepository;
import com.nexusmart.nexusmart_backend.serviceInterface.CartService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl  implements CartService{


    private final CartRepository cartRepository;
    //interface

    
    // List<Cart> getAllCarts();

    // Cart getCartById(Long id);

    // Cart createCart(Cart cart);

    // Cart updateCart(Long id,Cart cart);

    // void deleteCart(Long id);

    @Override
    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

    @Override
    public Cart getCartById(Long id){
        return cartRepository.findById(id).orElseThrow(()-> new RuntimeException("Cart not found with id "+ id));
    }

    @Override
    public Cart createCart(Cart cart){
       return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(Long id,Cart cart){
        return cartRepository.findById(id).map(existingCart ->{
            existingCart.setItems(cart.getItems());
            existingCart.setUser(cart.getUser());
            return cartRepository.save(existingCart);
        }).orElse(null);
    }

    @Override
    public void deleteCart(Long id){
        cartRepository.deleteById(id);
    }
}

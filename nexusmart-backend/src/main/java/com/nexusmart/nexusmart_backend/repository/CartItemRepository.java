package com.nexusmart.nexusmart_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexusmart.nexusmart_backend.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Long>{
    
    List<CartItem> findByCartId(Long cartId);
}
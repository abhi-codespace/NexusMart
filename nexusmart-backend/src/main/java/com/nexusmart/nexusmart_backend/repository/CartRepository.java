package com.nexusmart.nexusmart_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexusmart.nexusmart_backend.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Long>{
    Cart findByUserId(Long userId);
}

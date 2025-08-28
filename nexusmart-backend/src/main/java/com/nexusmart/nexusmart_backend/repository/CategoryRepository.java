package com.nexusmart.nexusmart_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexusmart.nexusmart_backend.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

    Optional<Category> findByCategoryName(String categoryName);

}

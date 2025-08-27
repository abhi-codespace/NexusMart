package com.nexusmart.nexusmart_backend.serviceInterface;

import java.util.List;

import com.nexusmart.nexusmart_backend.entity.Category;

public interface CategoryService {

    List<Category> getAllCategories();

    Category  getCategoryById(Long id);

    Category createCategory(Category category);

    Category updateCategory(Long id,Category category);

    void deleteCategory(Long id);
}

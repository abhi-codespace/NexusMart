package com.nexusmart.nexusmart_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nexusmart.nexusmart_backend.entity.Category;
import com.nexusmart.nexusmart_backend.repository.CategoryRepository;
import com.nexusmart.nexusmart_backend.serviceInterface.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    
    //Interface
    //  List<Category> getAllCategories();

    // Category  getCategoryById(Long id);

    // Category createCategory(Category category);

    // Category updateCategory(Long id,Category category);

    // void deleteCategory(Long id);

    //getting all Category in database

    @Override
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    // Getting all Category data with id in databse
    @Override
    public Category getCategoryById(Long id){
        return categoryRepository.findById(id)
        .orElseThrow(()->new RuntimeException("Category not found with the id "+id));
    }

    //Saving data to database
    @Override
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    //Updating data with id into database
    @Override
    public Category updateCategory(Long id,Category category){
        return categoryRepository.findById(id).map(existingCategory ->{
            existingCategory.setCategoryName(category.getCategoryName());
            existingCategory.setProduct(category.getProduct());
            return categoryRepository.save(existingCategory);
        }).orElse(null);
    }
    
    //Deleting data form database with id
    @Override
    public void deleteCategory(Long id){
        if(!categoryRepository.existsById(id)){
            throw new RuntimeException("Category not found with id "+ id);
        }
            categoryRepository.deleteById(id);
    }


    
}

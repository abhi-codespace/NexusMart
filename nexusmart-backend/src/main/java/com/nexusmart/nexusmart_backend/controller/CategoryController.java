package com.nexusmart.nexusmart_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexusmart.nexusmart_backend.entity.Category;
import com.nexusmart.nexusmart_backend.repository.CartItemRepository;
import com.nexusmart.nexusmart_backend.serviceInterface.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    //Get all category
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories=categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    //Get category by Id
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
       Category category= categoryService.getCategoryById(id);
       return ResponseEntity.ok(category);
    }

    //Create new category
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category savedCategory= categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    //update category
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id,@RequestBody Category category){
        Category updatedCategory=categoryService.updateCategory(id,category);
        if(updatedCategory ==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedCategory);
    }

    //Delete category
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully");
    }


}

package com.nexusmart.nexusmart_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nexusmart.nexusmart_backend.entity.Product;
import com.nexusmart.nexusmart_backend.repository.ProductRepository;
import com.nexusmart.nexusmart_backend.serviceInterface.ProductService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found with id "+ id));
    }

    @Override
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id,Product product){
            return productRepository.findById(id).map(existingProduct ->{
                existingProduct.setProductName(product.getProductName());
                existingProduct.setDescription(product.getDescription());
                existingProduct.setPrice(product.getPrice());
                existingProduct.setStock(product.getStock());
                existingProduct.setImageUrl(product.getImageUrl());
                existingProduct.setCategory(product.getCategory());
                return productRepository.save(existingProduct);
            }).orElse(null);
    }

    @Override
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
    
}

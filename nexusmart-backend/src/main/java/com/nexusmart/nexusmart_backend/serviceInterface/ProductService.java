package com.nexusmart.nexusmart_backend.serviceInterface;

import java.util.List;

import com.nexusmart.nexusmart_backend.entity.Product;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(Product product);

    Product updateProduct(Long id,Product product);
    
    void deleteProduct(Long id);

}

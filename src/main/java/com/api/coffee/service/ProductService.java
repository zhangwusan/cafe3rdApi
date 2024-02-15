package com.api.coffee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.coffee.models.Product;

@Service
public interface ProductService {
    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    String deleteProductById(Long id);

    Product updateAvailableProduct(Long id, Product product);

    Product getProductById(Long productId);

}

package com.api.coffee.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.coffee.models.Product;
import com.api.coffee.repository.ProductRepository;
import com.api.coffee.service.ProductService;

import lombok.NonNull;

@Component
public class ProductServiceImplement implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(@NonNull Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(@NonNull Long id, Product product) {
        Product productExist = productRepository.findById(id).get();
        productExist.setName(product.getName());
        productExist.setPrice(product.getPrice());
        productExist.setAvailable(product.isAvailable());
        return productRepository.save(productExist);
    }

    @Override
    public Product updateAvailableProduct(@NonNull Long id, Product product) {
        Product productExist = productRepository.findById(id).get();
        productExist.setAvailable(product.isAvailable());
        return productRepository.save(productExist);
    }

    @Override
    public String deleteProductById(@NonNull Long id) {
        productRepository.deleteById(id);
        return "deleted";
    }

    @Override
    public Product getProductById(@NonNull Long productId) {
        return productRepository.findById(productId).orElse(null);
    }
}

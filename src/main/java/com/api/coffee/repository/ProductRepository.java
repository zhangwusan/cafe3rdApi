package com.api.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.coffee.models.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}

package com.api.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.coffee.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
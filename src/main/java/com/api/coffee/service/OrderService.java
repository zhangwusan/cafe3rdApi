package com.api.coffee.service;

import java.util.List;

import com.api.coffee.models.Order;

public interface OrderService {
    List<Order> getAllOrders();

    Order createOrder(Order Order);

    Order updateOrder(Long id, Order Order);

    String deleteOrderById(Long id);

    Order getOrderById(Long OrderId);
}

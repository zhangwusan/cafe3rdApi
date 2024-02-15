package com.api.coffee.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.coffee.models.Order;
import com.api.coffee.repository.OrderRepository;
import com.api.coffee.service.OrderService;

import lombok.NonNull;

@Component
public class OrderServiceImplement implements OrderService {
    @Autowired
    private OrderRepository OrderRepository;

    @Override
    public List<Order> getAllOrders() {
        return OrderRepository.findAll();
    }

    @Override
    public Order createOrder(@NonNull Order Order) {
        return OrderRepository.save(Order);
    }

    @Override
    public Order updateOrder(@NonNull Long id, Order Order) {
        Order OrderExist = OrderRepository.findById(id).get();
        OrderExist.setUser(Order.getUser());
        OrderExist.setStaff(Order.getStaff());
        return OrderRepository.save(OrderExist);
    }


    @Override
    public String deleteOrderById(@NonNull Long id) {
        OrderRepository.deleteById(id);
        return "deleted";
    }

    @Override
    public Order getOrderById(@NonNull Long OrderId) {
        return OrderRepository.findById(OrderId).orElse(null);
    }
}

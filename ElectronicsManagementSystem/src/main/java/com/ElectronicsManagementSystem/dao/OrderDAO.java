package com.ElectronicsManagementSystem.dao;

import com.ElectronicsManagementSystem.entity.Order;
import com.ElectronicsManagementSystem.respository.OrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDAO {

    @Autowired
    private OrderRespository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(int orderId, Order order) {
        if (orderRepository.existsById(orderId)) {
            order.setOrderId(orderId);
            return orderRepository.save(order);
        }
        return null;
    }

    public boolean deleteOrder(int orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
            return true;
        }
        return false;
    }
}
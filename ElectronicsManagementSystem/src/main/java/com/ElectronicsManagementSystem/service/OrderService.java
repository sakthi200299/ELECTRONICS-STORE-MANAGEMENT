package com.ElectronicsManagementSystem.service;

import com.ElectronicsManagementSystem.dao.OrderDAO;
import com.ElectronicsManagementSystem.entity.Order;
import com.ElectronicsManagementSystem.Entity.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderService {
    private final OrderDAO orderDao;

    private final RestTemplate restTemplate;

    private final String customerServiceUrl = "http://localhost:8098/customer";

    @Autowired
    public OrderService(OrderDAO orderDao, RestTemplate restTemplate) {
        this.orderDao = orderDao;
        this.restTemplate = restTemplate;
    }

    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    public Order getOrderById(int orderId) {
        return orderDao.getOrderById(orderId);
    }

    public Order createOrder(int customerId) {
        Order order = new Order();

        Customers = fetchCustomerById(customerId);

        order.setCustomer(customer);
        order.setStatus("PENDING");
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));
        order.setOrderCost(0);
        return orderDao.createOrder(order);
    }

    public Order updateOrder(int orderId, Order order) {
        Order existingOrder = orderDao.getOrderById(orderId);

        if (existingOrder == null) {
            throw new RuntimeException("Order with ID " + orderId + " not found.");
        }

        existingOrder.setCustomer(order.getCustomer());
        existingOrder.setStatus(order.getStatus());
        existingOrder.setOrderDate(order.getOrderDate());
        existingOrder.setOrderCost(order.getOrderCost());

        return orderDao.updateOrder(orderId, existingOrder);
    }

    public boolean deleteOrder(int orderId) {
        return orderDao.deleteOrder(orderId);
    }

    private Customers fetchCustomerById(int customerId) {
        String url = customerServiceUrl + "/" + customerId;
        return restTemplate.getForObject(url, Customers.class);
    }
}
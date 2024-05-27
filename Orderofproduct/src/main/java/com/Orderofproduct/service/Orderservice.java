package com.Orderofproduct.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Orderofproduct.dao.Orderdao;
import com.Orderofproduct.entity.Orders;
import java.util.List;
@Service
public class Orderservice {

    @Autowired
    private Orderdao orderDAO;

    public List<Orders> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    public Orders getOrderById(int id) {
        return orderDAO.getOrderById(id);
    }

    public void createOrder(Orders order) {
        orderDAO.createOrder(order);
    }

    public Orders updateOrder(int id, Orders updatedOrder) {
        return orderDAO.updateOrder(id, updatedOrder);
    }

    public void deleteOrder(int id) {
        orderDAO.deleteOrder(id);
    }

   
}
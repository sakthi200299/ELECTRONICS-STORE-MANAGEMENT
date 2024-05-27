package com.Orderofproduct.service;
import com.Orderofproduct.dao.OrderProductdao;
import com.Orderofproduct.entity.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OrderProductService {

    @Autowired
    private OrderProductdao orderProductDAO;

    public List<OrderProduct> getAllOrderProducts() {
        return orderProductDAO.getAllOrderProducts();
    }

    public OrderProduct getOrderProductById(int id) {
        return orderProductDAO.getOrderProductById(id);
    }

    public void createOrderProduct(OrderProduct orderProduct) {
        orderProductDAO.createOrderProduct(orderProduct);
    }

    public OrderProduct updateOrderProduct(int id, OrderProduct updatedOrderProduct) {
        return orderProductDAO.updateOrderProduct(id, updatedOrderProduct);
    }

    public void deleteOrderProduct(int id) {
        orderProductDAO.deleteOrderProduct(id);
    }
}

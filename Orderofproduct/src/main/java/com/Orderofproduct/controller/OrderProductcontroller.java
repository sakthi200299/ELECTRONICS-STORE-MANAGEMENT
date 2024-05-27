package com.Orderofproduct.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Orderofproduct.entity.OrderProduct;
import com.Orderofproduct.service.OrderProductService;

import java.util.List;

@RestController
@RequestMapping("/orderproducts")
public class OrderProductcontroller {

    @Autowired
    private OrderProductService orderProductService;

    @GetMapping("/getall")
    public List<OrderProduct> getAllOrderProducts() {
        return orderProductService.getAllOrderProducts();
    }

    @GetMapping("/{id}")
    public OrderProduct getOrderProductById(@PathVariable int id) {
        return orderProductService.getOrderProductById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createOrderProduct(@RequestBody OrderProduct orderProduct) {
        orderProductService.createOrderProduct(orderProduct);
    }

    @PutMapping("/update/{id}")
    public OrderProduct updateOrderProduct(@PathVariable int id, @RequestBody OrderProduct updatedOrderProduct) {
        return orderProductService.updateOrderProduct(id, updatedOrderProduct);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrderProduct(@PathVariable int id) {
        orderProductService.deleteOrderProduct(id);
    }
}

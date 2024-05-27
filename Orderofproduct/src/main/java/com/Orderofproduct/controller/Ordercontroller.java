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
import com.Orderofproduct.entity.Orders;
import com.Orderofproduct.service.Orderservice;

import java.util.List;

@RestController
@RequestMapping("/orders")
//@CrossOrigin(origins="*")
public class Ordercontroller {

    @Autowired
    private Orderservice orderService;

    @GetMapping("/getall")
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createOrder(@RequestBody Orders order) {
        orderService.createOrder(order);
    }

    @PutMapping("/update/{id}")
    public Orders updateOrder(@PathVariable int id, @RequestBody Orders updatedOrder) {
        return orderService.updateOrder(id, updatedOrder);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }
    
}

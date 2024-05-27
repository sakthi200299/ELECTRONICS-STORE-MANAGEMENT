package com.Orderofproduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import com.Orderofproduct.entity.Customers;
import com.Orderofproduct.service.Customerservice;

@RestController
@RequestMapping("/customer")
//@CrossOrigin(origins="*")
public class Customercontroller {

    @Autowired
    private Customerservice customerService;
  
    @GetMapping("/all")
    public List<Customers> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customers getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createCustomer(@RequestBody Customers customer) {
    	customerService.createCustomer(customer);
    }

    @PutMapping("/update/{id}")
    public Customers updateStudent(@PathVariable int id, @RequestBody Customers updatedCustomer) {
        return customerService.updateCustomer(id, updatedCustomer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable int id) {
    	customerService.deleteCustomer(id);
    }
    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, String>> authenticateCustomer(@RequestBody Customers customer)
    {
        Map<String, String> response = new HashMap<>();
        if (customerService.authenticateCustomer(customer.getCustomerName(), customer.getCustomerPassword())) {
            response.put("message", "Authentication successful");
            response.put("customerId", String.valueOf(customer.getCustomerId())); // Assuming you have a method to get customer ID
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Authentication failed");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
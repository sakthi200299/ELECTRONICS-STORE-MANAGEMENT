package com.Orderofproduct.service;

import com.Orderofproduct.dao.Customerdao;
import com.Orderofproduct.entity.Customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Customerservice {

    @Autowired
    private Customerdao customerDAO;

    public List<Customers> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    public Customers getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }

    public void createCustomer(Customers customer) {
    	customerDAO.createCustomer(customer);
    }

    public Customers updateCustomer(int id, Customers updatedCustomer) {
        return customerDAO.updateCustomer(id, updatedCustomer);
    }

    public void deleteCustomer(int id) {
    	customerDAO.deleteCustomer(id);
    }
    public boolean authenticateCustomer(String username, String password)
    {
        Customers customer = customerDAO.findByCustomerName(username);
        return customer != null && password.equals(customer.getCustomerPassword());
    }

	
}
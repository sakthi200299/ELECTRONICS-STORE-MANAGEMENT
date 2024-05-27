package com.Orderofproduct.service;
import com.Orderofproduct.dao.Productdao;
import com.Orderofproduct.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class Productservice {

    @Autowired
    private Productdao productDAO;

    public List<Products> getAllProducts() {
        return  productDAO.getAllProducts();
    }

    public Products getProductById(int id) {
        return  productDAO.getProductById(id);
    }

    public void createProduct(Products product) {
    	 productDAO.createProduct(product);
    }

    public Products updateProduct(int id, Products updatedProduct) {
        return productDAO.updateProduct(id, updatedProduct);
    }

    public void deleteProduct(int id) {
    	 productDAO.deleteProduct(id);
    }
}

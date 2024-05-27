package com.Orderofproduct.dao;
import com.Orderofproduct.entity.Products;
import com.Orderofproduct.repository.Productrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class Productdao {

    @Autowired
    private Productrepository productRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Products getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public void createProduct(Products product) {
    	productRepository.save(product);
    }

    public Products updateProduct(int id, Products updatedProduct) {
        Products product = productRepository.findById(id).orElse(null);
        if (product  != null) {
        	product.setServiceTag(updatedProduct.getServiceTag());
        	product.setProductName(updatedProduct.getProductName());
        	product.setProductCost(updatedProduct.getProductCost());
            productRepository.save(product);
        }
        return product;
    }

    public void deleteProduct(int id) {
    	productRepository.deleteById(id);
    }
}


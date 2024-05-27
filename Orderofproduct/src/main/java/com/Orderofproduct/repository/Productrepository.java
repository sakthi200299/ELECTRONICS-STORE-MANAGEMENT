package com.Orderofproduct.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Orderofproduct.entity.Products;
public interface Productrepository  extends JpaRepository<Products,Integer>{

}
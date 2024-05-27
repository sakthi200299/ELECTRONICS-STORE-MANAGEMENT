package com.Orderofproduct.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Orderofproduct.entity.Customers;
public interface Customerrepository extends JpaRepository<Customers,Integer>{

	Customers findByCustomerName(String username);

}


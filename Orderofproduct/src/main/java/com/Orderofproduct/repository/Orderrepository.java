package com.Orderofproduct.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Orderofproduct.entity.Orders;
public interface Orderrepository extends JpaRepository<Orders,Integer> {

}



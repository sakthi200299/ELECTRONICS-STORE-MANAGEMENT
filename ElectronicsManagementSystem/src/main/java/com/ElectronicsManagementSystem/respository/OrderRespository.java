package com.ElectronicsManagementSystem.respository;

import com.ElectronicsManagementSystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRespository extends JpaRepository<Order, Integer> {
}
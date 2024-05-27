package com.ElectronicsManagementSystempayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ElectronicsManagementSystempayment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
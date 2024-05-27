package com.ElectronicsManagementSystempayment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ElectronicsManagementSystempayment.entity.Payment;
import com.ElectronicsManagementSystempayment.repository.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class PaymentDAO {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> findById(int id) {
        return paymentRepository.findById(id);
    }

    public void deleteById(int id) {
        paymentRepository.deleteById(id);
    }
}
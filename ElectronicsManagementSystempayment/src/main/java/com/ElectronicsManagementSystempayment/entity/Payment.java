package com.ElectronicsManagementSystempayment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "amount")
    private int amount;

    @Column(name = "payment_status")
    private Boolean paymentStatus;

    @Column(name = "order_id")
    private int orderid;

    // Constructors
    public Payment() {}

    public Payment(int paymentId, String customerName, int amount, Boolean paymentStatus,int order) {
        this.paymentId = paymentId;
        this.customerName = customerName;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.orderid = order;
    }

    // Getters and setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getOrder() {
        return orderid;
    }

    public void setOrder(int orderid) {
        this.orderid = orderid;
    }

    @Override
    public String toString() {
        return "Payment [paymentId=" + paymentId + ", customerName=" + customerName + ", amount=" + amount + ", paymentStatus=" + paymentStatus + ", order=" + orderid + "]";
    }
}
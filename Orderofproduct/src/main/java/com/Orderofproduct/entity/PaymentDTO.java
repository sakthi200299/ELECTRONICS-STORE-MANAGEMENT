package com.Orderofproduct.entity;
public class PaymentDTO {
    
    private int paymentId;
    
    private String customerName;
    
    private int amount;

    private Boolean paymentStatus;
    
    private int orderId;

    // Constructors
    public PaymentDTO() {}

    public PaymentDTO(int paymentId, String customerName, int amount, Boolean paymentStatus, int orderId) {
        this.paymentId = paymentId;
        this.customerName = customerName;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.orderId = orderId;
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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "PaymentDTO [paymentId=" + paymentId + ", customerName=" + customerName + ", amount=" + amount + ", paymentStatus=" + paymentStatus + ", orderId=" + orderId + "]";
    }
}

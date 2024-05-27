package com.Orderofproduct.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="product_id")
    private int productId;

    @Column(name="product_servicetag")
    private String serviceTag;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_cost")
    private int productCost;

    public Products() {
    }

    public Products(String serviceTag, String productName, int productCost) {
        this.serviceTag = serviceTag;
        this.productName = productName;
        this.productCost = productCost;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getServiceTag() {
        return serviceTag;
    }

    public void setServiceTag(String serviceTag) {
        this.serviceTag = serviceTag;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductCost() {
        return productCost;
    }

    public void setProductCost(int productCost) {
        this.productCost = productCost;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", serviceTag=" + serviceTag + ", productName=" + productName + ", productCost=" + productCost + "]";
    }
}


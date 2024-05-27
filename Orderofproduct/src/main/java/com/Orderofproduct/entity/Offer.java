package com.Orderofproduct.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id")
    private int offerId;

    @Column(name = "offer_description")
    private String offerDescription;

    @ManyToOne(targetEntity = Orders.class)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Orders orderid;

    // Constructors, getters, and setters

    public Offer() {}

    public Offer(String offerDescription, Orders orderid) {
        this.offerDescription = offerDescription;
        this.orderid = orderid;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    public Orders getOrder() {
        return orderid;
    }

    public void setOrder(Orders order) {
        this.orderid = order;
    }
     @Override
        public String toString() 
     {
            return "Offer [offerId=" + offerId + ", offerDescription=" + offerDescription + ", order=" + orderid + "]";
        }

    
}

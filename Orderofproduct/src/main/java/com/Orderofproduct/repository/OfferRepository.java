package com.Orderofproduct.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Orderofproduct.entity.Offer;
public interface OfferRepository extends JpaRepository<Offer, Integer>
{
}

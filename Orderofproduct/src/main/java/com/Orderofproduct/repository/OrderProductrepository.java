package com.Orderofproduct.repository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.Orderofproduct.entity.OrderProduct;

@Repository
@Configuration
@EntityScan(basePackages = "com.Orderofproduct.entity")
@EnableJpaRepositories(basePackages = "com.Orderofproduct.repository")
public interface OrderProductrepository extends JpaRepository<OrderProduct, Integer> {
}

package com.microservices.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
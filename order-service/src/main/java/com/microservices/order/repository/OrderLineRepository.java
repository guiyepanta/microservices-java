package com.microservices.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.order.model.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

}

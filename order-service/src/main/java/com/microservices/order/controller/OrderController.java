package com.microservices.order.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.microservices.order.dto.OrderDTO;
import com.microservices.order.model.Order;
import com.microservices.order.service.OrderService;

@RestController
public class OrderController {

  @Autowired
  private OrderService orderService;

  @GetMapping("/{id}")
  public Order findById(@PathVariable Long id) {
    return orderService.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/")
  public List<Order> findAll() {
    return orderService.findAll();
  }

  @PostMapping("/")
  public Order addOrder(@RequestBody OrderDTO order) {
    return orderService.addOrder(order);
  }
}

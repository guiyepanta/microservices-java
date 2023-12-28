package com.microservices.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.microservices.order.dto.ProductDTO;

@FeignClient("product-service")
public interface ProductServiceClient {

  @PutMapping("/product-service/{productId}/{unitsToRemove}")
  ProductDTO removeStock(@PathVariable("productId") Long productId,
    @PathVariable("unitsToRemove") Integer unitsToRemove);
}

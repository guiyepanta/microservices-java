package com.microservices.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.order.dto.UserDTO;

@FeignClient("user-service")
public interface UserServiceClient {

  @GetMapping("/user-service/{userId}")
  UserDTO findUserById(@PathVariable("userId") Long userId);
}

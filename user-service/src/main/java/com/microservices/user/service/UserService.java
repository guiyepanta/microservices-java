package com.microservices.user.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.user.model.User;
import com.microservices.user.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public Optional<User> findById(Long userId) {
    return userRepository.findById(userId);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }
}

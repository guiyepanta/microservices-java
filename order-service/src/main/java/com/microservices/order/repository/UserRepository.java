package com.microservices.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.order.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

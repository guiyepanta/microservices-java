package com.microservices.product.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.product.exception.InsufficientStockException;
import com.microservices.product.exception.ProductNotFoundException;
import com.microservices.product.model.Product;
import com.microservices.product.repository.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public Optional<Product> findById(Long userId) {
    return productRepository.findById(userId);
  }

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  @Transactional
  public Product removeStock(Long productId, int unitsToRemove) {
    Product product = productRepository.findById(productId)
      .orElseThrow(ProductNotFoundException::new);

    int stockLeft = product.getStock();
    if (stockLeft < unitsToRemove) {
      throw new InsufficientStockException();
    }

    product.setStock(stockLeft - unitsToRemove);
    return productRepository.save(product);
  }
}

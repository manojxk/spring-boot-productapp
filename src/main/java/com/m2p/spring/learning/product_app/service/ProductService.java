package com.m2p.spring.learning.product_app.service;

import com.m2p.spring.learning.product_app.model.Product;
import com.m2p.spring.learning.product_app.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  // Retrieve all products
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  // Retrieve a product by its ID
  public Product getProductById(Long id) {
    return productRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
  }

  // Create or update a product
  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  // Delete a product by its ID
  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }
}

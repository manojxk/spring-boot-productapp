package com.m2p.spring.learning.product_app.repository;

import com.m2p.spring.learning.product_app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  // No additional code is needed here! Spring Data JPA will generate the CRUD methods.
}

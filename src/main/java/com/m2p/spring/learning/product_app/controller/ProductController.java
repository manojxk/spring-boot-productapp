package com.m2p.spring.learning.product_app.controller;

import com.m2p.spring.learning.product_app.model.Product;
import com.m2p.spring.learning.product_app.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  // Retrieve all products
  @GetMapping
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  // Retrieve a product by its ID
  @GetMapping("/{id}")
  public Product getProductById(@PathVariable Long id) {
    return productService.getProductById(id);
  }

  // Create a new product
  @PostMapping
  public Product createProduct(@RequestBody Product product) {
    return productService.saveProduct(product);
  }

  // Update an existing product
  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
    Product existingProduct = productService.getProductById(id);
    existingProduct.setName(productDetails.getName());
    existingProduct.setPrice(productDetails.getPrice());
    return productService.saveProduct(existingProduct);
  }

  // Delete a product by its ID
  @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
  }
}

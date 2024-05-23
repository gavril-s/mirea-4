// ProductService.java
package com.example.Task19.service;

import com.example.Task19.Product;
import com.example.Task19.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Импорт Transactional

import java.util.List;

@Service
@Transactional // Добавление аннотации Transactional
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        logger.debug("Creating product: {}", product);
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    public List<Product> getAllProducts() {
        logger.debug("Retrieving all products");
        return productRepository.findAll();
    }

    public void deleteProduct(Long id) {
        logger.debug("Deleting product with ID: {}", id);
        productRepository.deleteById(id);
    }

    public void deleteAllProducts() {
        logger.debug("Deleting all products");
        productRepository.deleteAll();
    }

    public List<Product> filterProducts(String name, Double price) {
        logger.debug("Filtering products by name: {} and price: {}", name, price);
        return productRepository.findByNameAndPrice(name, price);
    }
}

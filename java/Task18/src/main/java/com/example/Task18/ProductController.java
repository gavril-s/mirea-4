package com.example.Task18;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully");
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @DeleteMapping("/products")
    public ResponseEntity<String> deleteAllProducts() {
        productService.deleteAllProducts();
        return ResponseEntity.ok("All products deleted successfully");
    }

    @GetMapping("/products/filter")
    public ResponseEntity<List<Product>> filterProducts(@RequestParam(required = false) String name,
                                                        @RequestParam(required = false) Double price) {
        List<Product> filteredProducts = productService.filterProducts(name, price);
        return ResponseEntity.ok(filteredProducts);
    }
}




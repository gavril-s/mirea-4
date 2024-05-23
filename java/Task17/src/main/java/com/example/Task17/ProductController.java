package com.example.Task17;

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
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully");
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            productRepository.deleteById(id);
            return ResponseEntity.ok("Product deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
    }

    @DeleteMapping("/products")
    public ResponseEntity<String> deleteAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        for (Product product : allProducts) {
            productRepository.deleteById(product.getId());
        }
        return ResponseEntity.ok("All products deleted successfully");
    }

    @GetMapping("/products/filter")
    public ResponseEntity<List<Product>> filterProducts(@RequestParam(required = false) String name,
                                                        @RequestParam(required = false) Double price) {
        List<Product> filteredProducts = productRepository.findAll((Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (name != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("name"), name));
            }
            if (price != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("price"), price));
            }
            return predicate;
        });
        return ResponseEntity.ok(filteredProducts);
    }
}


